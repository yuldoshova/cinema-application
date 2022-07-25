package uz.pdp.cinemaapplication.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uz.pdp.cinemaapplication.entity.Genre;
import uz.pdp.cinemaapplication.repository.DirectorRepository;

@ContextConfiguration(classes = {DirectorService.class})
@ExtendWith(SpringExtension.class)
class DirectorServiceTest {
    @MockBean
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorService directorService;

    /**
     * Method under test: {@link DirectorService#saveGenre(Genre)}
     */
    @Test
    void testSaveGenre() {
        Genre genre = new Genre();
        genre.setCreatedAt(mock(Timestamp.class));
        genre.setCreatedBy(1);
        genre.setId(1);
        genre.setName("Name");
        genre.setUpdatedAt(mock(Timestamp.class));
        genre.setUpdatedBy(1);
        assertTrue(this.directorService.saveGenre(genre));
    }

    /**
     * Method under test: {@link DirectorService#saveGenre(Genre)}
     */
    @Test
    void testSaveGenre2() {
        Genre genre = mock(Genre.class);
        doNothing().when(genre).setName((String) any());
        doNothing().when(genre).setCreatedAt((Timestamp) any());
        doNothing().when(genre).setCreatedBy((Integer) any());
        doNothing().when(genre).setId((Integer) any());
        doNothing().when(genre).setUpdatedAt((Timestamp) any());
        doNothing().when(genre).setUpdatedBy((Integer) any());
        genre.setCreatedAt(mock(Timestamp.class));
        genre.setCreatedBy(1);
        genre.setId(1);
        genre.setName("Name");
        genre.setUpdatedAt(mock(Timestamp.class));
        genre.setUpdatedBy(1);
        assertTrue(this.directorService.saveGenre(genre));
        verify(genre).setName((String) any());
        verify(genre).setCreatedAt((Timestamp) any());
        verify(genre).setCreatedBy((Integer) any());
        verify(genre).setId((Integer) any());
        verify(genre).setUpdatedAt((Timestamp) any());
        verify(genre).setUpdatedBy((Integer) any());
    }

    /**
     * Method under test: {@link DirectorService#saveGenre(Genre)}
     */
    @Test
    void testSaveGenre3() {
        Genre genre = new Genre();
        genre.setCreatedAt(mock(Timestamp.class));
        genre.setCreatedBy(1);
        genre.setId(1);
        genre.setName("Name");
        genre.setUpdatedAt(mock(Timestamp.class));
        genre.setUpdatedBy(1);
        assertTrue(this.directorService.saveGenre(genre));
    }

    /**
     * Method under test: {@link DirectorService#saveGenre(Genre)}
     */
    @Test
    void testSaveGenre4() {
        Genre genre = mock(Genre.class);
        doNothing().when(genre).setName((String) any());
        doNothing().when(genre).setCreatedAt((Timestamp) any());
        doNothing().when(genre).setCreatedBy((Integer) any());
        doNothing().when(genre).setId((Integer) any());
        doNothing().when(genre).setUpdatedAt((Timestamp) any());
        doNothing().when(genre).setUpdatedBy((Integer) any());
        genre.setCreatedAt(mock(Timestamp.class));
        genre.setCreatedBy(1);
        genre.setId(1);
        genre.setName("Name");
        genre.setUpdatedAt(mock(Timestamp.class));
        genre.setUpdatedBy(1);
        assertTrue(this.directorService.saveGenre(genre));
        verify(genre).setName((String) any());
        verify(genre).setCreatedAt((Timestamp) any());
        verify(genre).setCreatedBy((Integer) any());
        verify(genre).setId((Integer) any());
        verify(genre).setUpdatedAt((Timestamp) any());
        verify(genre).setUpdatedBy((Integer) any());
    }
}

