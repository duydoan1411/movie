package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Episode {

    @Id
    @Column(name = "episode_id")
    private int episodeId;

    @ManyToOne
    @JsonBackReference("movie-episode")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "link")
    private String link;

    @Column(name = "title")
    private String title;

    @Column(name = "episode_order")
    private int episodeOrder;

    public Episode(String link, String title) {
        this.link = link;
        this.title = title;
    }
}
