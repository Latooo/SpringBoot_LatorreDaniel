package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personService.save(new Person(null, "Daniel", "Lato"));
        personService.save(new Person(null, "Pedro", "Gomez"));
        personService.save(new Person(null, "El", "Cote"));
        personService.save(new Person(null, "Valle", "Dupar"));
    }
}
