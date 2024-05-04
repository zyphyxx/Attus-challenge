package com.attus.challenge.controllers;

import com.attus.challenge.dtos.Mapper;
import com.attus.challenge.dtos.PersonRequest;
import com.attus.challenge.dtos.PersonResponse;
import com.attus.challenge.entities.Person;
import com.attus.challenge.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED, reason = "Created successfully")
    public ResponseEntity<PersonResponse>  createPerson (@RequestBody PersonRequest request){
        personService.createPerson(Mapper.toPerson(request));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<PersonResponse> updatePerson (@PathVariable Long id,@RequestBody PersonRequest request){
        Person person = Mapper.toPerson(request);
        personService.updatePerson(id,person);
        return ResponseEntity.ok().body(Mapper.toResponse(person));
    }

    @GetMapping("/findby/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Optional<Person>> findPersonByID (@PathVariable Long id){
        Optional<Person> person = personService.findPersonByID(id);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/findall")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<PersonResponse>> findAllPerson () {
        return ResponseEntity.ok().body(Mapper.toList(personService.findAllPerson()));
    }


}
