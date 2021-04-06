package com.duydoanx.film.service.director;

import com.duydoanx.film.dao.DirectorRepository;
import com.duydoanx.film.dao.EntityRepository;
import com.duydoanx.film.entity.Director;
import com.duydoanx.film.service.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorCRUDServiceImpl extends CRUDServiceImpl<Director> {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorCRUDServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public EntityRepository<Director> injectRepository() {
        return directorRepository;
    }
}
