package com.duydoanx.film.controller.movie;

import com.duydoanx.film.controller.CRUDController;
import com.duydoanx.film.entity.Movie;
import com.duydoanx.film.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieCRUDController extends CRUDController<Movie> {

    private final CRUDService<Movie> movieService;

    @Autowired
    public MovieCRUDController(CRUDService<Movie> movieService) {
        this.movieService = movieService;
    }


    @Override
    public CRUDService<Movie> injectEntityService() {
        return movieService;
    }
}
