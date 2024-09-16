package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Person> findAll() {
        return persons;
    }

    public Optional<Person> findById(Long id) {
        return persons.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    public Person save(Person person) {
        if (person.getId() == null) {
            person.setId(idCounter.incrementAndGet());
        }
        persons.removeIf(p -> p.getId().equals(person.getId()));
        persons.add(person);
        return person;
    }

    public void deleteById(Long id) {
        persons.removeIf(person -> person.getId().equals(id));
    }
}
