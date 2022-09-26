package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
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

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonById(@RequestParam Integer id) throws NotFoundException {
        return personService.getPersonById(id);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Person updatePerson(@RequestParam Integer id, @RequestBody Person person) throws NotFoundException {
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@RequestParam Integer id) throws NotFoundException {
        personService.deletePerson(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Person> getAll() {
        return personService.getAllPersons();
    }
}
