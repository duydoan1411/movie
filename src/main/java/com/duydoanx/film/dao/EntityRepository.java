package com.duydoanx.film.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface EntityRepository<T> extends PagingAndSortingRepository<T, Integer> {
}
