package com.duydoanx.film.service;

import com.duydoanx.film.dao.EntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

public abstract class CRUDServiceImpl<T> implements CRUDService<T>{

    private EntityRepository<T> entityRepository;

    @PostConstruct
    private void setEntityRepository(){
        entityRepository = injectRepository();
    }

    public abstract EntityRepository<T> injectRepository();

    @Override
    public List<T> getItems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> moviePage = entityRepository.findAll(pageable);
        return moviePage.getContent();
    }

    @Override
    public T getItem(int id) {
        Optional<T> item = entityRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public T saveOrUpdate(T item) {
        return entityRepository.save(item);
    }

    @Override
    public void detele(int id) {
        entityRepository.deleteById(id);
    }

    @Override
    public long size() {
        return entityRepository.count();
    }
}
