package com.duydoanx.film.service.person;

import com.duydoanx.film.dao.EntityRepository;
import com.duydoanx.film.dao.PersonRepository;
import com.duydoanx.film.entity.Person;
import com.duydoanx.film.service.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonCRUDServiceImpl extends CRUDServiceImpl<Person> {

    private final PersonRepository personRepository;

    public PersonCRUDServiceImpl(PersonRepository movieRepository) {
        this.personRepository = movieRepository;
    }

    @Override
    public EntityRepository<Person> injectRepository() {
        return personRepository;
    }

}
