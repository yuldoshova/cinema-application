package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinemaapplication.dto.RowDto;
import uz.pdp.cinemaapplication.dto.SeatDto;
import uz.pdp.cinemaapplication.entity.Row;
import uz.pdp.cinemaapplication.entity.Seat;
import uz.pdp.cinemaapplication.service.RowService;

@RestController
@RequestMapping("/api/row")
public class
RowController {

    @Autowired
    RowService rowService;

    @GetMapping
    public ResponseEntity allRows() {
        return ResponseEntity.ok(rowService.getAllRows());
    }


    @GetMapping("/{id}")
    public ResponseEntity getRowById(@PathVariable Integer id) {
        Row rowById = rowService.getRowById(id);
        return rowById != null ? ResponseEntity.ok(rowById) :
                ResponseEntity.notFound().build();
    }


    @PostMapping()
    public ResponseEntity saveRow(@RequestBody RowDto rowDto) {
        boolean result = rowService.saveRow(rowDto);
        return result ?
                new ResponseEntity("Successfully saved", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not save", HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteRow(@PathVariable Integer id) {
        boolean result = rowService.deleteRow(id);
        if (result)
            return ResponseEntity.noContent().build();
        return
                ResponseEntity.notFound().build();
    }


}
