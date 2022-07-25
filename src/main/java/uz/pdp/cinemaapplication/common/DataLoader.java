package uz.pdp.cinemaapplication.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.pdp.cinemaapplication.entity.Distributor;
import uz.pdp.cinemaapplication.entity.Movie;
import uz.pdp.cinemaapplication.repository.DistributorRepository;
import uz.pdp.cinemaapplication.repository.MovieRepository;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.sql.init.mode}")
    String initMode;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DistributorRepository distributorRepository;

    @Override
    public void run(String... args) throws Exception {

        if (initMode.equals("always")) {

            Distributor distributor1 = new Distributor("Walt Disney", "The best of the best");
            Distributor distributor2 = new Distributor("Distributor1", "The best of the best");
            Distributor distributor3 = new Distributor("Distributor2", "The best of the best");
            Distributor distributor4 = new Distributor("Distributor3", "The best of the best");
            distributorRepository.save(distributor1);
            distributorRepository.save(distributor2);
            distributorRepository.save(distributor3);
            distributorRepository.save(distributor4);


            Movie movie1 = new Movie();
            movie1.setBudget(1170.0);
            movie1.setDescription("This film is  very interesting");
            movie1.setDistributorShareInPercent(70);
            movie1.setDurationInMinutes(10);
            movie1.setMinPrice(100.0);
            movie1.setReleaseDate(LocalDate.of(2022, 4, 1));
            movie1.setTitle("Batman");
            movie1.setTrailerVideoUrl("youtube.com");
            movie1.setDistributor(distributor1);
            movieRepository.save(movie1);

            Movie movie2 = new Movie();
            movie2.setBudget(1370.0);
            movie2.setDescription("This film is  very interesting");
            movie2.setDistributorShareInPercent(70);
            movie2.setDurationInMinutes(10);
            movie2.setMinPrice(200.0);
            movie2.setReleaseDate(LocalDate.of(2022, 4, 1));
            movie2.setTitle("Spiderman");
            movie2.setTrailerVideoUrl("youtube.com");
            movie2.setDistributor(distributor2);
            movieRepository.save(movie2);

            Movie movie3 = new Movie();
            movie3.setBudget(1270.0);
            movie3.setDescription("This film is  very interesting");
            movie3.setDistributorShareInPercent(80);
            movie3.setDurationInMinutes(10);
            movie3.setMinPrice(500.0);
            movie3.setReleaseDate(LocalDate.of(2021, 4, 1));
            movie3.setTitle("Superman");
            movie3.setTrailerVideoUrl("youtube.com");
            movie3.setDistributor(distributor3);
            movieRepository.save(movie3);

            Movie movie4 = new Movie();
            movie4.setBudget(1870.0);
            movie4.setDescription("This film is  very interesting");
            movie4.setDistributorShareInPercent(80);
            movie4.setDurationInMinutes(10);
            movie4.setMinPrice(700.0);
            movie4.setReleaseDate(LocalDate.of(2020, 4, 1));
            movie4.setTitle("Batman 2");
            movie4.setTrailerVideoUrl("youtube.com");
            movie4.setDistributor(distributor4);
            movieRepository.save(movie4);


        }
    }
}
