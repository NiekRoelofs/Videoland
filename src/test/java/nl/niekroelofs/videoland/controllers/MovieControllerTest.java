package nl.niekroelofs.videoland.controllers;

import nl.niekroelofs.videoland.models.Movie;
import nl.niekroelofs.videoland.repository.MovieRepository;
import nl.niekroelofs.videoland.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService movieService;

    private Movie movie;


}