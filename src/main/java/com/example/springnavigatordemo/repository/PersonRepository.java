package com.example.springnavigatordemo.repository;

import com.example.springnavigatordemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
