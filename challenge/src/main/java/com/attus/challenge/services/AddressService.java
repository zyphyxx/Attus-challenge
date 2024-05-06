package com.attus.challenge.services;

import com.attus.challenge.entities.Address;
import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final PersonService personService;

    public AddressService(AddressRepository addressRepository, PersonService personService) {
        this.addressRepository = addressRepository;
        this.personService = personService;
    }

    public void addAddress (Address address,Long id) throws NoSuchElementException {
        Person person = personService.findPersonByID(id).get();
        if (personService.findPersonByID(id).isPresent()) {
            address.setPerson(person);
            addressRepository.save(address);
            personService.updatePerson(id, person);
        }
    }

    public Optional<Address> findAddressByID (Long id) throws
            NoSuchElementException {
        return addressRepository.findById(id);
    }

    public void updateAddress(Long id, Address request) throws
            NoSuchElementException {
        Address address = findAddressByID(id).get();
        if (findAddressByID(id).isPresent()) {
            address.setZipCode(request.getZipCode());
            address.setCity(request.getCity());
            address.setCountry(request.getCountry());
            address.setStreet(request.getStreet());
            address.setNumber(request.getNumber());
            addressRepository.save(address);
        }
        // TODO: 05/05/2024
    }

    public List<Address> findAllAddress() {
      return addressRepository.findAll();
    }

}
