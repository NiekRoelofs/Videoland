package nl.niekroelofs.videoland.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity //class is persistent Java class
@Table(name = "movies") //table for database
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Movie {

    @Id //indicates primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment field
    private Long id;

    @Column(name = "title") //column in database
    private String title;

    @ManyToOne
    private Genre genre;

    @Column(name = "published")
    private boolean published;

    public Movie() {
    }

    public Movie(String title, Genre genre, boolean published) {
        this.title = title;
        this.genre = genre;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", genre=" + genre.getName() + ", published=" + published + "]";
    }
}
