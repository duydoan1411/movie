package com.duydoanx.film.service.episode;

import com.duydoanx.film.dao.EntityRepository;
import com.duydoanx.film.dao.EpisodeRepository;
import com.duydoanx.film.entity.Episode;
import com.duydoanx.film.service.CRUDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EpisodeCRUDServiceImpl extends CRUDServiceImpl<Episode> {

    private final EpisodeRepository episodeRepository;

    public EpisodeCRUDServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public EntityRepository<Episode> injectRepository() {
        return episodeRepository;
    }

}
