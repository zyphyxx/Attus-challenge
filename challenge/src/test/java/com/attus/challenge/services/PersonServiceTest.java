package com.attus.challenge.services;

import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve criar um usuario com sucesso caso tudo estiver ok")
    void createPersonCase1() {
        Long testID = 1L;
        Person person = new Person(1L,"Test","04/05/2023");
        person.setId(testID);
        personRepository.save(person);

        when(personService.findPersonByID(testID)).thenReturn(Optional.of(person));

        verify(personRepository, times(1)).save(person);
    }

    @Test
    @DisplayName("Deve lançar uma exception caso der erro")
    void createPersonCase2() {

    }

    @Test
    void findPersonByID() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void findAllPerson() {
    }
}