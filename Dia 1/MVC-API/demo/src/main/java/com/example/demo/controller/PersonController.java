package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        if (!personService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        person.setId(id);
        return ResponseEntity.ok(personService.save(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (!personService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
