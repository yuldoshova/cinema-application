package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    boolean existsGenreById(Integer id);


}
