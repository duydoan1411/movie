package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "movie_cast")
public class MovieCast {

    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MovieCastKey movieCastKey;

    @JsonBackReference("movie-cast")
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    //@JsonBackReference("person-movie-cast")
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "cast_order")
    private Integer castOrder;

    public MovieCast(String characterName, Integer castOrder) {
        this.characterName = characterName;
        this.castOrder = castOrder;
    }
}
