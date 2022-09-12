package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.collection.PersonCollection;
import com.zdotavv.enterprise_homework3.collection.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    private static Integer PEOPLE_COUNT = 0;
    @Autowired
    private PersonCollection personCollection;
    @Override
    public Person createPerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        PersonCollection.persons.add(person);
        return person;
    }

    @Override
    public Person getPersonById(Integer id) throws NotFoundException {
        Person person = new Person();
        for (Person tmp : PersonCollection.persons) {
            if (tmp.getId() == id) {
                person = tmp;
            }
            else {
                throw new NotFoundException("Person with ID #" + id + " is not found");
            }
        }
        return person;

    }
    @Override
    public void deletePerson(Integer id) throws NotFoundException{

      if  (personCollection.persons.removeIf(tmp -> tmp.getId().equals(id)));
      else {
          throw new NotFoundException("Person with ID #" + id + " is not found");
      }
    }
    @Override
    public Person updatePerson(Person person) throws NotFoundException{
        Person newPerson = new Person();
        for (Person tmp : PersonCollection.persons)
            if (tmp.getId().equals(person.getId())) {
                tmp.setId(person.getId());
                tmp.setFirstName(person.getFirstName());
                tmp.setLastName(person.getLastName());
                tmp.setEmail(person.getEmail());
                newPerson = tmp;
            }
            else {
                throw new NotFoundException("Person with ID #" + person.getId() + " is not found");
            }
        return newPerson;
    }
    @Override
    public Set<Person> getAllPerson() {
        return PersonCollection.persons;
    }
}
