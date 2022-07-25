package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.PriceCategory;
@Repository
public interface PriceCategoryRepository extends JpaRepository<PriceCategory, Integer> {
}
