package uz.pdp.cinemaapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "waiting_purchase_time")
@PackagePrivate
public class WaitingPurchaseTime extends AbsEntity {

    Integer minute;
}
