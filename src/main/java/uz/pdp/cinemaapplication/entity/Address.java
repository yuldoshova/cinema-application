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
@Entity(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
public class Address extends AbsEntity {

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String street;

    String homeNumber;
}
