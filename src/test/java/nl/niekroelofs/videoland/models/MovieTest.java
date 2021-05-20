package nl.niekroelofs.videoland.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie();
    }

    @Test
    public void createMovieShouldNotBeNull() {
        assertNotNull(movie);
    }

}