package nl.niekroelofs.videoland.repository;

import nl.niekroelofs.videoland.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByPublished(boolean published);
    List<Movie> findByTitleContaining(String title);
}
