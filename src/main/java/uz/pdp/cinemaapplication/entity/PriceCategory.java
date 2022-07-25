package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "price_categories")
@PackagePrivate
public class PriceCategory extends AbsEntity {

    @Column(nullable = false, unique = true)
    String name;

    @Column(name = "add_fee_in_percent")
    Integer addFeeInPercent;

}
