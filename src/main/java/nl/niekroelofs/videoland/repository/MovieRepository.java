package nl.niekroelofs.videoland.repository;

import nl.niekroelofs.videoland.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //JpaRepository contains API for CRUD operations
    List<Movie> findByPublished(boolean published);
    List<Movie> findByTitleContaining(String title);

    @Query("SELECT m FROM Movie m WHERE m.title = ?1")
    Optional<Movie> findMovieByTitle(String title);
}
