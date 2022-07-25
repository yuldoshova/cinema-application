package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "movies")
@PackagePrivate
public class Movie extends AbsEntity {

    @Column(nullable = false, length = 50)
    String title;

    @Column(columnDefinition = "text")
    String description;

    @Column(name = "duration_in_minutes")
    Integer durationInMinutes;

    @OneToOne
    Attachment coverImage;

    @Column(nullable = false)
    String trailerVideoUrl;

    Double minPrice;

    @ManyToOne
    Distributor distributor;

    @Column(name = "distributor_share_in_persent")
    Integer distributorShareInPercent;

    Double budget;

    LocalDate releaseDate; // ishlab chiqarilish sanasi

    @ManyToMany
    @JoinTable(name = "movies_actors",
            joinColumns = @JoinColumn(
                    name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "actor_id", referencedColumnName = "id")
    )
    List<Actor> actors;


    @ManyToMany
    @JoinTable(name = "movies_directors",
            joinColumns = @JoinColumn(
                    name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "director_id", referencedColumnName = "id")
    )
    List<Director> directors;


    @ManyToMany
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(
                    name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id", referencedColumnName = "id")
    )
    List<Genre> genres;




}
