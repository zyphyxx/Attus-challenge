package com.attus.challenge.dtos;

import com.attus.challenge.dtos.address.AddressReponse;
import com.attus.challenge.dtos.address.AddressRequest;
import com.attus.challenge.dtos.person.PersonRequest;
import com.attus.challenge.dtos.person.PersonResponse;
import com.attus.challenge.entities.Address;
import com.attus.challenge.entities.Person;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    public static Person toPerson(PersonRequest request) {
        return new Person(request.getId(), request.getFullName(),
                request.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static PersonResponse toResponse(Person request) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setFullName(request.getFullName());
        personResponse.setBirthDate(request.getBirthDate());
        personResponse.setAddressList(request.getAddressList());
        return personResponse;

    }

    public static List<PersonResponse> toList(List<Person> personList) {

        List<PersonResponse> responseList = new ArrayList<>();

        for (Person person : personList) {
            PersonResponse personResponse = new PersonResponse();

            personResponse.setId(person.getId());
            personResponse.setFullName(person.getFullName());
            personResponse.setBirthDate(person.getBirthDate());

            responseList.add(personResponse);
        }
        return responseList;
    }

    public static Address toAddress(AddressRequest request) {

        return new Address(
                request.getZipCode(), request.getCity(),
                request.getCountry(), request.getStreet(),
                request.getNumber());
    }

    public static AddressReponse toResponseAddress(Address response) {

        return new AddressReponse(response.getZipCode(), response.getCity(),
                response.getCountry(), response.getStreet(),
                response.getNumber());

    }

    public static List<AddressReponse> toListAddress(List<Address> addressList) {
        List<AddressReponse> reponses = new ArrayList<>();
        for (Address address : addressList) {
            AddressReponse addressReponse = new AddressReponse(
                    address.getZipCode(), address.getCity(), address.getCountry(),
                    address.getStreet(), address.getNumber());

            reponses.add(addressReponse);
        }
        return reponses;
    }
}
