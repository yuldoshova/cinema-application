package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "movie_announcements")
@PackagePrivate
public class MovieAnnouncement extends AbsEntity {

    @OneToOne
    Movie movie;

    boolean isActive;
}
