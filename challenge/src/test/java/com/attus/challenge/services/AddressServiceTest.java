package com.attus.challenge.services;

import com.attus.challenge.entities.Address;
import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.AddressRepository;
import com.attus.challenge.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void addAddress() {

    }

    @Test
    void findAddressByID() {

    }

    @Test
    void updateAddress() {
    }

    @Test
    void findAllAddress() {
    }
}