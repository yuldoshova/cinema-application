package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinemaapplication.entity.Director;
import uz.pdp.cinemaapplication.entity.Genre;
import uz.pdp.cinemaapplication.repository.DirectorRepository;
import uz.pdp.cinemaapplication.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {


    @Autowired
    DirectorRepository directorRepository;

    public List<Director> getAllDirectors() {
        List<Director> allDirectors = directorRepository.findAll();
        return allDirectors;
    }

    public Director getDirectorById(Integer id) {
        Optional<Director> directorById = directorRepository.findById(id);
        return directorById.get();
    }


    public boolean deleteDirector(Integer id) {
        try {
            directorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean saveGenre(Genre genre) {
     return true;
    }

    public boolean editGenre(Integer id, Genre genre) {
        return true;
    }

}
