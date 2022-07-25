package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.cinemaapplication.dto.SeatDto;
import uz.pdp.cinemaapplication.entity.PriceCategory;
import uz.pdp.cinemaapplication.entity.Seat;
import uz.pdp.cinemaapplication.repository.PriceCategoryRepository;
import uz.pdp.cinemaapplication.repository.SeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    PriceCategoryRepository priceCategoryRepository;


    public List<Seat> getAllSeats() {
        List<Seat> allSeats = seatRepository.findAll();
        return allSeats;
    }


    public Seat getSeatById(Integer id) {
        Optional<Seat> optionalSeat = seatRepository.findById(id);
        return optionalSeat.orElse(null);
    }


    public boolean saveSeat(SeatDto seatDto) {
        PriceCategory priceCategory = new PriceCategory();
        priceCategory.setName(seatDto.getCategoryName());
        priceCategory.setAddFeeInPercent(seatDto.getAddFeeInPercent());

        priceCategoryRepository.save(priceCategory);

        Seat seat = new Seat();
        seat.setNumber(seatDto.getNumber());
        seat.setPriceCategory(priceCategory);

        Seat savedSeat = seatRepository.save(seat);
        return savedSeat != null;
    }



    public boolean editSeat(Integer id, SeatDto seatDto) {
        Seat editSeat = getSeatById(id);
        editSeat.setNumber(seatDto.getNumber());

        PriceCategory priceCategory = editSeat.getPriceCategory();
        priceCategory.setName(seatDto.getCategoryName());
        priceCategory.setAddFeeInPercent(seatDto.getAddFeeInPercent());
        priceCategoryRepository.save(priceCategory);
        editSeat.setPriceCategory(priceCategory);
        Seat saved = seatRepository.save(editSeat);
        return saved!=null ;
    }



    public boolean deleteSeat(Integer id) {
        try {
            seatRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
