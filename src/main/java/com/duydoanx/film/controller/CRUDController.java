package com.duydoanx.film.controller;

import com.duydoanx.film.exception.ItemAddFailureException;
import com.duydoanx.film.exception.ItemNotFoundException;
import com.duydoanx.film.exception.OutPageSizeException;
import com.duydoanx.film.service.CRUDService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public abstract class CRUDController<T> {

    private CRUDService<T> entityService;

    public abstract CRUDService<T> injectEntityService();

    @PostConstruct
    private void setEntityService() {
        entityService = injectEntityService();
    }

    @GetMapping
    public List<T> getItems(@RequestParam("page") int page, @RequestParam("size") int size){

        page--;
        if ((long) page * size >= entityService.size()) {
            throw new OutPageSizeException();
        }else
            if (page < 0 || size < 0) throw new RuntimeException("The page and size must be greater than zero!");

        return entityService.getItems(page, size);
    }

    @GetMapping("/{id}")
    public T getMovie(@PathVariable(name = "id") int id){
        T item = entityService.getItem(id);

        if (item == null) throw new ItemNotFoundException(String.valueOf(id));

        return item;
    }

    @PostMapping
    public T createMovie(@RequestBody T item){

        Class<?> itemClass = item.getClass();

        Field[] allFields = itemClass.getDeclaredFields();

        Field neededField = null;
        for (Field field : allFields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation : annotations){
                if (annotation instanceof Id) {
                    neededField = field;
                    break;
                }
            }
            if (neededField != null) break;
        }
        try {
            assert neededField != null;
            neededField.setAccessible(true);
            if (neededField.getInt(item) != 0) throw new ItemAddFailureException("Please remove movieId field!");
        }catch (IllegalAccessException exception){
            throw new RuntimeException("There was an error processing!");
        }
        return entityService.saveOrUpdate(item);
    }

    @PutMapping
    public T updateMovie(@RequestBody T item) {
        return entityService.saveOrUpdate(item);
    }
}
