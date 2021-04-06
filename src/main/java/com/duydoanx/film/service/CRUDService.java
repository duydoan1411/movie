package com.duydoanx.film.service;

import java.util.List;

public interface CRUDService<T> {
    public List<T> getItems(int page, int size);
    public T getItem(int id);
    public T saveOrUpdate(T item);
    public void detele(int id);
    public long size();
}
