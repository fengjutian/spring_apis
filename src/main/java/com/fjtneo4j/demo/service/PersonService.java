package com.fjtneo4j.demo.service;

import com.fjtneo4j.demo.entity.Person;
import com.fjtneo4j.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person personData) {
        return personRepository.findById(id)
                .map(p -> {
                    p.setName(personData.getName());
                    p.setAge(personData.getAge());
                    return personRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}
