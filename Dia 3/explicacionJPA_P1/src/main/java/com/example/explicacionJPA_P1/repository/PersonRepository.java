package com.example.explicacionJPA_P1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.explicacionJPA_P1.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
