package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinemaapplication.entity.Genre;
import uz.pdp.cinemaapplication.payload.Result;
import uz.pdp.cinemaapplication.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping()
    public ResponseEntity allGenres() {
        List<Genre> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    public ResponseEntity genreById(@PathVariable Integer id) {
        Genre genreById = genreService.getGenreById(id);
        return genreById != null ? ResponseEntity.ok(genreById) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity saveGenre(@RequestBody Genre genre) {
        boolean result = genreService.saveGenre(genre);
        return result ?
                new ResponseEntity("Successfully saved", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not save", HttpStatus.CONFLICT);
    }


    @PutMapping("/{id}")
    public ResponseEntity editGenre(@PathVariable Integer id, @RequestBody Genre genre) {
        Result result = genreService.editGenre(id, genre);
        if (result.isSuccess()) {
            return ResponseEntity.ok("Successfully updated!");
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteGenre(@PathVariable Integer id) {
        boolean result = genreService.deleteGenre(id);
        if (result)
            return ResponseEntity.ok(new Result("success", true, result));
        return
                ResponseEntity.ok(new Result("error", false, result));
    }
}
