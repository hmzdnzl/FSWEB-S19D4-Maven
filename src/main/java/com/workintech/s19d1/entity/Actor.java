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
@Table(name="actor", schema = "film")
public class Actor {
 
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name = "gender")
private Gender gender;

@Column(name="birth_date")
private LocalDate birthDate;

public void addMovie(Movie movie) {
this.movies.add(movie);
movie.getActors().add(this);

  
}

 public void setMovies(java.util.List<Movie> movies) {
        this.movies = new java.util.HashSet<>(movies);
    }

      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}
