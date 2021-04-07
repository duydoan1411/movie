package com.duydoanx.film.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    private String title;

    private String homepage;

    private String overview;

    @Column(name = "release_date")
    private Date releaseDate;

    private Integer runtime;

    @Column(name = "movie_status")
    private String movieStatus;

    @Column(name = "vote_average")
    private BigDecimal voteAverage;

    @Column(name = "vote_count")
    private Integer voteCount;

    @Column(name = "is_tv_show")
    private boolean isTVShow;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference("movie-cast")
    private List<MovieCast> movieCasts;

    @OneToMany(mappedBy = "movie")
    //@JsonManagedReference("movie-episode")
    private List<Episode> episode;

    @ManyToMany
    @JoinTable(
            name = "movie_company",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    @JsonIgnoreProperties("movies")
    private List<ProductionCompany> productionCompanies;

    @ManyToMany
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @JsonIgnoreProperties("movies")
    private List<Person> directors;

    public Movie(String title, String homepage, String overview, Date releaseDate, Integer runtime,
                 String movieStatus, BigDecimal voteAverage, Integer voteCount, boolean isTVShow) {
        this.title = title;
        this.homepage = homepage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.movieStatus = movieStatus;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.isTVShow = isTVShow;
    }
}
