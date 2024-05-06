package com.attus.challenge.controllers;

import com.attus.challenge.dtos.Mapper;
import com.attus.challenge.dtos.person.PersonRequest;
import com.attus.challenge.dtos.person.PersonResponse;
import com.attus.challenge.entities.Person;
import com.attus.challenge.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request) {
        try {
            Person person = Mapper.toPerson(request);
            personService.createPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(Mapper.toResponse(person));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id, @RequestBody PersonRequest request) {
        try {
            Person person = Mapper.toPerson(request);
            personService.updatePerson(id, person);
            return ResponseEntity.status(HttpStatus.OK).body(Mapper.toResponse(person));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PersonResponse> findPersonByID(@PathVariable Long id) {
        Optional<Person> personByID = personService.findPersonByID(id);
        if (personByID.isPresent()) {
            Person person = personByID.get();
            return ResponseEntity.status(HttpStatus.OK).body(Mapper.toResponse(person));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @GetMapping("/find/all")
    public ResponseEntity<List<PersonResponse>> findAllPerson() {
        try {
            List<Person> allPerson = personService.findAllPerson();
            return ResponseEntity.ok().body(Mapper.toList(allPerson));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }


}
