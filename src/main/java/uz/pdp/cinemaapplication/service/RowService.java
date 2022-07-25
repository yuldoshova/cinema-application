package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinemaapplication.dto.RowDto;
import uz.pdp.cinemaapplication.dto.SeatDto;
import uz.pdp.cinemaapplication.entity.PriceCategory;
import uz.pdp.cinemaapplication.entity.Row;
import uz.pdp.cinemaapplication.entity.Seat;
import uz.pdp.cinemaapplication.repository.PriceCategoryRepository;
import uz.pdp.cinemaapplication.repository.RowRepository;
import uz.pdp.cinemaapplication.repository.SeatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RowService {

    @Autowired
    RowRepository rowRepository;


    public List<Row> getAllRows() {
        List<Row> rows = rowRepository.findAll();
        return rows;
    }


    public Row getRowById(Integer id) {
        Optional<Row> oneRow = rowRepository.findById(id);
        if (oneRow.isPresent()) {
            return oneRow.get();
        }
        return null;
    }


    public boolean saveRow(RowDto rowDto) {
      return false;
    }



    public boolean editRow(Integer id, RowDto rowDto) {
      return false;
    }



    public boolean deleteRow(Integer id) {
        try {
            rowRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
