package ru.netology.springmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.springmvc.entity.Persons;
import ru.netology.springmvc.service.MyService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class MyController {

    private final MyService service;

    @GetMapping()
    public String get() {
        return "test";
    }

    @GetMapping("/persons")
    public List<Persons> getAll() {
        return service.getAll();
    }

    @GetMapping("/persons/by-city")
    public List<Persons> findByCityOfLivingLikeIgnoreCase(@RequestParam String city) {
        return service.findByCityOfLivingLikeIgnoreCase(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> findByPk_AgeLessThanOrderByPk_AgeAsc(@RequestParam int age) {
        return service.findByPk_AgeLessThanOrderByPk_AgeAsc(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Persons> findByPk_NameAndPk_Surname(@RequestParam String name, @RequestParam String surname) {
        return service.findByPk_NameAndPk_Surname(name, surname);
    }

    @PostMapping("/persons")
    public void save(@RequestBody Persons person) {
        service.save(person);
    }

    @DeleteMapping("/persons/delete")
    public void delete(@RequestBody Persons person) {
        service.deleteById(person);
    }

    @DeleteMapping("/persons")
    public void deleteAll() {
        service.deleteAll();
    }

}

