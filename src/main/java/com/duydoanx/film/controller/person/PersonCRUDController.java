package com.duydoanx.film.controller.person;

import com.duydoanx.film.controller.CRUDController;
import com.duydoanx.film.entity.Person;
import com.duydoanx.film.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonCRUDController extends CRUDController<Person> {

    private final CRUDService<Person> personCRUDService;

    public PersonCRUDController(CRUDService<Person> personCRUDService) {
        this.personCRUDService = personCRUDService;
    }

    @Override
    public CRUDService<Person> injectEntityService() {
        return personCRUDService;
    }
}
