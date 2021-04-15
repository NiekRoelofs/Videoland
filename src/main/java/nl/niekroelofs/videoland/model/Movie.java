package nl.niekroelofs.videoland.model;

import javax.persistence.*;

@Entity //class is persistent Java class
@Table(name = "movies") //table for database
public class Movie {

    @Id //indicates primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment field
    private long id;

    @Column(name = "title") //column in database
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "published")
    private boolean published;

    public Movie() {

    }

    public Movie(String title, String genre, boolean published) {
        this.title = title;
        this.genre = genre;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
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
        return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", published=" + published + "]";
    }
}
