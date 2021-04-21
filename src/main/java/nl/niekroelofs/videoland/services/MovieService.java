package nl.niekroelofs.videoland.services;

import nl.niekroelofs.videoland.models.Movie;
import nl.niekroelofs.videoland.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByTitleContaining(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    public Optional<Movie> getMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMovieByPublished(boolean published) {
        return movieRepository.findByPublished(published);
    }

    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }
}
