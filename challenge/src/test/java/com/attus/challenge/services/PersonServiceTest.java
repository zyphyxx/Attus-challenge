package com.attus.challenge.services;

import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Criar Pessoa com Dados Válidos")
    void createPersonCase1() {
        Person expected = new Person(1L, "Edgar", "01/01/2000");

        personService.createPerson(expected);

        verify(personRepository).save(expected);
    }

    @Test
    @DisplayName("Criar Pessoa e Verificar Diferença")
    void createPersonCase2() {
        Person expected = new Person(1L, "Edgar", "01/01/2000");
        Person actual = new Person(1L, "Edgar", "01/01/2000");

        personService.createPerson(expected);

        verify(personRepository).save(expected);
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Deve encontrar um usuario se o ID estiver correto")
    void findPersonByIdCase1() {
        Long userId = 1L;
        Person expectedPerson = new Person(1L, "John Doe", "01/01/2000");
        when(personRepository.findById(userId)).thenReturn(Optional.of(expectedPerson));

        Person actualPerson = personService.findPersonByID(userId).get();

        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    @DisplayName("Os usuarios devem ser pessoas diferentes")
    void findPersonByIdCase2() {

        Person expectedPerson1 = new Person(1L, "Edgar", "01/01/2000");
        Person expectedPerson2 = new Person(2L, "Edgar", "01/01/2000");

        when(personRepository.findById(1L)).thenReturn(Optional.of(expectedPerson1));
        when(personRepository.findById(2L)).thenReturn(Optional.of(expectedPerson2));

        Person actualPerson1 = personService.findPersonByID(1L).get();
        Person actualPerson2 = personService.findPersonByID(2L).get();
        assertNotEquals(actualPerson1, actualPerson2);
    }


    @Test
    void updatePerson() {


    }

    @Test
    void findAllPerson() {

        List<Person> expectedPersons = Arrays.asList(
                new Person(1L, "John Doe", "01/01/2000"),
                new Person(2L, "Jane Smith", "02/02/2001")

        );

        when(personRepository.findAll()).thenReturn(expectedPersons);

        List<Person> actualPersons = personService.findAllPerson();

        verify(personRepository).findAll();

        assertEquals(expectedPersons, actualPersons);
    }
}
