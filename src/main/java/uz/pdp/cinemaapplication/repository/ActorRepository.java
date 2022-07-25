package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Actor;
import uz.pdp.cinemaapplication.entity.Distributor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    boolean existsActorById(Integer id);


}
