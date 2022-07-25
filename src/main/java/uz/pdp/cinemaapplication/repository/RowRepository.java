package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Row;

@Repository
public interface RowRepository extends JpaRepository<Row, Integer> {
}
