package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {


     boolean existsDistributorById(Integer id);

}
