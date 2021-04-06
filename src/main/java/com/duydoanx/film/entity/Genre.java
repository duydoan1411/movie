package com.duydoanx.film.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Genre {

    @Id
    @Column(name = "genre_id")
    private int genreId;

    @Column(name = "genre_name")
    private String genreName;

    public Genre(String genreName) {
        this.genreName = genreName;
    }
}
