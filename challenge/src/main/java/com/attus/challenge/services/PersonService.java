package com.attus.challenge.services;

import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> findPersonByID(Long id) throws
            NoSuchElementException {
        return personRepository.findById(id);
    }

    public void updatePerson(Long id, Person request) throws
            NoSuchElementException {
        Person person = findPersonByID(id).get();
        if (findPersonByID(id).isPresent()) {
            person.setFullName(request.getFullName());
            person.setBirthDate(request.getBirthDate());
            person.setAddressList(request.getAddressList());
            personRepository.save(person);
        }
        // TODO: 05/05/2024
    }

    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }
}
