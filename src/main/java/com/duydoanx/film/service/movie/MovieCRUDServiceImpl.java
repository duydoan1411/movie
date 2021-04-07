package com.duydoanx.film.service.movie;

import com.duydoanx.film.dao.EntityRepository;
import com.duydoanx.film.dao.MovieRepository;
import com.duydoanx.film.entity.Movie;
import com.duydoanx.film.service.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieCRUDServiceImpl extends CRUDServiceImpl<Movie>{

    private final MovieRepository movieRepository;

    public MovieCRUDServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public EntityRepository<Movie> injectRepository() {
        return movieRepository;
    }

}
