package com.workintech.s19d1.entity;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie", schema = "film")
public class Movie {

    @ManyToMany
    @JoinTable(
     name = "movie_actor",
     schema = "film",
     joinColumns = @JoinColumn(name="movie_id"),
     inverseJoinColumns = @JoinColumn(name = "actor_id")   
    )
    private Set<Actor> actors = new HashSet<>();


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

@Column(name="name")
private String name;

@Column(name="director_name")
private String directorName;

@Column(name="rating")
private double rating;

@Column(name="release_date")
private LocalDate releaseDate;

public void addActor(Actor actor) {
    this.actors.add(actor);
    actor.getMovies().add(this);
   
}


 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }
}
