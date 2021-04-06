package com.duydoanx.film.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class MovieCastKey implements Serializable {

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "person_id")
    private int personId;

    public MovieCastKey(int movieId, int personId) {
        this.movieId = movieId;
        this.personId = personId;
    }
}
