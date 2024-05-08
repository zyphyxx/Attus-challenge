package com.attus.challenge.entities;

import com.attus.challenge.enums.MainAdress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    String zipCode = "08693200";
    String city = "Mogi";
    String country = "SP";
    String street = "Rua do Ouro";
    Integer number = 224;
    Long id = 1L;

    Address address = new Address(zipCode,city,country,street,number);
    Address newAddress = new Address();
    Person newPerson = new Person();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getId() {
        assertNull(address.getId());
    }

    @Test
    void getZipCode() {
        assertEquals(address.getZipCode(),zipCode);
    }

    @Test
    void getCity() {
        assertEquals(address.getCity(),city);
    }

    @Test
    void getCountry() {
        assertEquals(address.getCountry(),country);
    }

    @Test
    void getStreet() {
        assertEquals(address.getStreet(),street);
    }

    @Test
    void getNumber() {
        assertEquals(address.getNumber(),number);
    }

    @Test
    void getMainAdress() {
        address.setMainAdress(MainAdress.ENDERECO_SECUNDARIO);
        assertEquals(address.getMainAdress(),MainAdress.ENDERECO_SECUNDARIO);
    }

    @Test
    void getPerson() {

        address.setPerson(newPerson);
        assertEquals(address.getPerson(),newPerson);
    }

    @Test
    void setId() {
       newAddress.setId(id);
       assertEquals(newAddress.getId(),id);
    }

    @Test
    void setZipCode() {
        newAddress.setZipCode(zipCode);
        assertEquals(newAddress.getZipCode(),zipCode);
    }

    @Test
    void setCity() {
        newAddress.setCity(city);
        assertEquals(newAddress.getCity(),city);
    }

    @Test
    void setCountry() {
        newAddress.setCountry(country);
        assertEquals(newAddress.getCountry(),country);
    }

    @Test
    void setStreet() {
        newAddress.setStreet(street);
        assertEquals(newAddress.getStreet(),street);
    }

    @Test
    void setNumber() {
        newAddress.setNumber(number);
        assertEquals(newAddress.getNumber(),number);
    }

    @Test
    void setMainAdress() {
        newAddress.setMainAdress(MainAdress.ENDERECO_PRINCIPAL);
        assertEquals(newAddress.getMainAdress(),MainAdress.ENDERECO_PRINCIPAL);
    }

    @Test
    void setPerson() {
        address.setPerson(newPerson);
        assertEquals(address.getPerson(),newPerson);

    }
}