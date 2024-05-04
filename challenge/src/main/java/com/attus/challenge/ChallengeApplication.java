package com.attus.challenge;

import com.attus.challenge.entities.Person;
import com.attus.challenge.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        personRepository.save(new Person("Edgar","06/09/1997"));
        personRepository.save(new Person("Anny","25/09/1995"));
    }
}
