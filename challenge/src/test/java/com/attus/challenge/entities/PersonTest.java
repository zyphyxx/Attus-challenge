package com.attus.challenge.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Long id = 1L;
    String fullName = "Edgar Mendes";
    String birthDate = "10/09/2000";
    Person newPerson = new Person(id,fullName, birthDate);
    Person person = new Person();


    @BeforeEach
    void setUp() {
    }

    @Test
    void getId() {
        assertEquals(newPerson.getId(),id);
    }

    @Test
    void getFullName() {
        assertEquals(newPerson.getFullName(),fullName);
    }

    @Test
    void getBirthDate() {
        assertEquals(newPerson.getBirthDate(),LocalDate.parse(birthDate,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Test
    void setId() {
        person.setId(id);
        assertEquals(person.getId(),id);
    }

    @Test
    void setFullName() {
        person.setFullName(fullName);
        assertEquals(person.getFullName(),fullName);
    }

    @Test
    void setBirthDate() {
        person.setBirthDate(LocalDate.parse(birthDate,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assertEquals(person.getBirthDate(),person.getBirthDate());
    }

}