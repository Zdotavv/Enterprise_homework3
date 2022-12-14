package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Person;

import java.util.Collection;

public interface PersonService {
    Person createPerson(Person person);

    Person getPersonById(Integer id) throws NotFoundException;

    Person updatePerson(Integer Id, Person person) throws NotFoundException;

    void deletePerson(Integer id) throws NotFoundException;

    Collection<Person> getAllPersons();
}
