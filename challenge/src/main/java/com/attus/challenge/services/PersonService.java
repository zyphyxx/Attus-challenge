package com.attus.challenge.services;

import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public void createPerson (Person person){
        personRepository.save(person);
    }
    public Optional<Person> findPersonByID (Long id){
        return personRepository.findById(id);
    }
    public void updatePerson (Long id,Person person){
        Optional<Person> personByID = findPersonByID(id);
        Person newPerson = personByID.get();

        newPerson.setFullName(person.getFullName());
        newPerson.setBirthDate(person.getBirthDate());

        personRepository.save(newPerson);
    }
    public List<Person> findAllPerson () {
        return personRepository.findAll();
    }
}
