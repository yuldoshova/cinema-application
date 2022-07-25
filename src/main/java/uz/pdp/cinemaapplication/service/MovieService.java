package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinemaapplication.dto.MovieDto;
import uz.pdp.cinemaapplication.entity.Movie;
import uz.pdp.cinemaapplication.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }


    public Movie getMovieById(Integer id) {
        Optional<Movie> optionalActor = movieRepository.findById(id);
        return optionalActor.orElse(null);
    }


    public boolean deleteMovie(Integer id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveMovie(MovieDto movieDto){

        return true;
    }



}
