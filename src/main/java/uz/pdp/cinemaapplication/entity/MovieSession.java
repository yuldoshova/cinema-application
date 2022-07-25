package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "movie_sessions")
@PackagePrivate
public class MovieSession extends AbsEntity {

    @OneToOne
    MovieAnnouncement movieAnnouncement;

    @ManyToOne
    private Hall hall;

    @ManyToOne
    private SessionDate startDate;

    @ManyToOne
    private SessionTime startTime;

    @ManyToOne
    private SessionTime endTime;


}
