package com.example.jpaonetoone;

import com.example.jpaonetoone.model.CCCD;
import com.example.jpaonetoone.model.Person;
import com.example.jpaonetoone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaOneToOneApplication implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Huy", new CCCD()));
        personList.add(new Person("Son", new CCCD()));
        personRepository.saveAll(personList);
    }
}
