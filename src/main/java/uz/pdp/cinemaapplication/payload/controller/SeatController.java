package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinemaapplication.dto.SeatDto;
import uz.pdp.cinemaapplication.entity.Seat;
import uz.pdp.cinemaapplication.service.SeatService;

@RestController
@RequestMapping("/api/seat")
public class
SeatController {

    @Autowired
    SeatService seatService;

    @GetMapping
    public ResponseEntity<?> allSeats() {
        return ResponseEntity.ok(seatService.getAllSeats());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable Integer id) {
        Seat seatById = seatService.getSeatById(id);
        return seatById != null ? ResponseEntity.ok(seatById) :
                ResponseEntity.notFound().build();
    }


    @PostMapping()
    public ResponseEntity<?> saveSeat(@RequestBody SeatDto seatDto) {
        boolean result = seatService.saveSeat(seatDto);
        return result ?
                new ResponseEntity("Successfully saved", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not save", HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable Integer id) {
        boolean result = seatService.deleteSeat(id);
        if (result)
            return ResponseEntity.noContent().build();
        return
                ResponseEntity.notFound().build();
    }



}
