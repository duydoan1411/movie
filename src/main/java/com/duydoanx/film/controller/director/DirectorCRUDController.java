package com.duydoanx.film.controller.director;

import com.duydoanx.film.controller.CRUDController;
import com.duydoanx.film.entity.Director;
import com.duydoanx.film.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorCRUDController extends CRUDController<Director> {

    private final CRUDService<Director> directorCRUDService;

    @Autowired
    public DirectorCRUDController(CRUDService<Director> directorCRUDService) {
        this.directorCRUDService = directorCRUDService;
    }

    @Override
    public CRUDService<Director> injectEntityService() {
        return directorCRUDService;
    }

}
