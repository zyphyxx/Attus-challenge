package com.attus.challenge.dtos;

import com.attus.challenge.entities.Person;
import org.springframework.stereotype.Service;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Mapper {

    public static PersonResponse optionalToResponse (Optional<Person> response){
        Person person = new Person(response.get().getFullName(),
                response.get().getBirthDate()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        PersonResponse personResponse = new PersonResponse();
        personResponse.setFullName(person.getFullName());
        personResponse.setBirthDate(person.getBirthDate());

        return personResponse;
    }

    public static Person toPerson (PersonRequest request){
        return new Person(request.getFullName(),
                request.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    public static PersonResponse toResponse (Person request){
         PersonResponse personResponse = new PersonResponse();

         personResponse.setFullName(request.getFullName());
         personResponse.setBirthDate(request.getBirthDate());
         return personResponse;

    }

    public static List<PersonResponse> toList (List<Person> personList ) {

        List<PersonResponse> responseList = new ArrayList<>();

        for (Person person : personList){
            PersonResponse personResponse = new PersonResponse();

            personResponse.setId(person.getId());
            personResponse.setFullName(person.getFullName());
            personResponse.setBirthDate(person.getBirthDate());

            responseList.add(personResponse);
        }
        return responseList;
    }

}
