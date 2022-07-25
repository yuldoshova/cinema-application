package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Director;
import uz.pdp.cinemaapplication.entity.Distributor;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {


}
