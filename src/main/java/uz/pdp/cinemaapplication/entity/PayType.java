package uz.pdp.cinemaapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "pay_types")
@PackagePrivate
public class PayType extends AbsEntity {

    String name;

    @Column(name = "commission_fee_in_percent")
    Integer commissionFeeInPercent;

}
