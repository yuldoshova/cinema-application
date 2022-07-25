package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "rows")
@PackagePrivate
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"number","hall_id"}))
//number va hall id qatorini birgalikda unique qilib beradi!

public class Row extends AbsEntity {

    Integer number;

    @ManyToOne
    Hall hall;


}
