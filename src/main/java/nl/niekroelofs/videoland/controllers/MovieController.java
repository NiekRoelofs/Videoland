package nl.niekroelofs.videoland.controllers;

import nl.niekroelofs.videoland.models.Movie;
import nl.niekroelofs.videoland.repository.MovieRepository;
import nl.niekroelofs.videoland.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {
        try {
            List<Movie> movies = new ArrayList<Movie>();

            if (title == null) {
                movieService.getAllMovies().forEach(movies::add);
            } else {
                 movieService.getMoviesByTitleContaining(title).forEach(movies::add);
            }

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            //ResponseEntity represents the whole HTTP response, so status, headers and body
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long id) {
        Optional<Movie> movieData = movieRepository.findById(id);
        //Optional is an container object which may or may not contain a non-null value
        //Check on Optional with isPresent() to see if it's filled
        if (movieData.isPresent()) {
            return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/movies/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable("title") String title) {
        Optional<Movie> movieData = movieService.getMovieByTitle(title);
        //Optional is an container object which may or may not contain a non-null value
        //Check on Optional with isPresent() to see if it's filled
        if (movieData.isPresent()) {
            return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        try {
            Movie _movie = movieService.addMovie(new Movie(movie.getTitle(), movie.getGenre(), false));
            return new ResponseEntity<>(_movie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id, @RequestBody Movie movie) {
        Optional<Movie> movieData = movieService.getMovieById(id);

        if (movieData.isPresent()) {
            Movie _movie = movieData.get();
            _movie.setTitle(movie.getTitle());
            _movie.setGenre(movie.getGenre());
            _movie.setPublished(movie.isPublished());
            return new ResponseEntity<>(movieService.addMovie(_movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
        try {
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("movies/published")
    public ResponseEntity<List<Movie>> findByPublished() {
        try {
            List<Movie> movies = movieService.getMovieByPublished(true);

            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}