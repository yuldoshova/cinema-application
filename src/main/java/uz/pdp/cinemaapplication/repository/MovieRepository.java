package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
