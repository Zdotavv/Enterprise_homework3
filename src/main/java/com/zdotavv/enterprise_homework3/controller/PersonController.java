package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.collection.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Person;
import com.zdotavv.enterprise_homework3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(path="/person")
    @RestController
    public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person){
    return personService.createPerson(person);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@RequestParam Integer id) throws NotFoundException {
       return personService.getPersonById(Integer.valueOf(id));
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestBody Person person) throws NotFoundException {
        return personService.updatePerson(person);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@RequestParam Integer id) throws NotFoundException {
        personService.deletePerson(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Person> getAll() {
        return personService.getAllPerson();
    }

}
