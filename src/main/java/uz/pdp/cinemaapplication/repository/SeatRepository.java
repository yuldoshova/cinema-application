package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Seat;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
