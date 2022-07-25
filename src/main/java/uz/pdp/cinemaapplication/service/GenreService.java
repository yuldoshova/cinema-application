package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinemaapplication.entity.Genre;
import uz.pdp.cinemaapplication.payload.Result;
import uz.pdp.cinemaapplication.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        List<Genre> allGenres = genreRepository.findAll();
        return allGenres;
    }

    public Genre getGenreById(Integer id) {
        Optional<Genre> genreById = genreRepository.findById(id);
        return genreById.get();
    }


    public boolean deleteGenre(Integer id) {
        try {
            genreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean saveGenre(Genre genre) {
        Genre newGenre = new Genre(genre.getName());
        Genre saved = genreRepository.save(newGenre);
        return saved != null;
    }

    public Result editGenre(Integer id, Genre genre) {
        boolean isExist = genreRepository.existsGenreById(id);
        if (!isExist) {
            return new Result("Bunday genre mavjut emas!!!",false);
        }
        Genre genreById = getGenreById(id);
        genreById.setName(genre.getName());
        return new Result("Successfully edited!!!", true, genreById);
    }

}
