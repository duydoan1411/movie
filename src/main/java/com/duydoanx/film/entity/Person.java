package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @Column(name = "person_id")
    protected int personId;

    @Column(name = "person_name")
    protected String personName;

    //@JsonBackReference("person-gender")
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @JsonBackReference("person-movie-cast")
    @OneToMany(mappedBy = "person")
    private List<MovieCast> movieCasts;

    @ManyToMany
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @JsonIgnoreProperties("directors")
    private List<Movie> movies;

    public Person(String personName) {
        this.personName = personName;
    }
}
