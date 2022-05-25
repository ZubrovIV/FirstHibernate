package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Film")
public class Film {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "film_name")
    private String filmName;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public Film() {
    }

    public Film(String filmName, Director director) {
        this.filmName = filmName;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", filmName='" + filmName + '\'' +
                '}';
    }
}
