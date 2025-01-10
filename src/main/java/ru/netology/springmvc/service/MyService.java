package ru.netology.springmvc.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springmvc.entity.PK;
import ru.netology.springmvc.entity.Persons;
import ru.netology.springmvc.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyService {

    private final PersonsRepository personsRepository;

    public List<Persons> findByCity(String city) {
        return personsRepository.findByCity(city);
    }

    public List<Persons> findByAge(int age) {
        return personsRepository.findByAge(age);
    }

    public Optional<Persons> findByNameAndSurname(String name, String surname) {
        return personsRepository.findByNameAndSurname(name, surname);
    }

    public void save(Persons person) {
        personsRepository.save(person);
    }

    public List<Persons> getAll() {
        return personsRepository.findAll();
    }

    public void deleteAll() {
        personsRepository.deleteAll();
    }

    public void deleteById(Persons pk) {
        personsRepository.delete(pk);
    }

}