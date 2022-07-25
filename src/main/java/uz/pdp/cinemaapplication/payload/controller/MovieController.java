package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.cinemaapplication.entity.Movie;
import uz.pdp.cinemaapplication.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity allMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }



    @GetMapping("/{id}")
    public ResponseEntity oneMovie(@PathVariable Integer id) {
        Movie movieById = movieService.getMovieById(id);
        return ResponseEntity.ok(movieById);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id) {
        boolean deleted = movieService.deleteMovie(id);
        return deleted ?
                new ResponseEntity("Successfully deleted!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not delete!!!", HttpStatus.CONFLICT);
    }


 
}
