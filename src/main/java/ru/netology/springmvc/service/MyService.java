package ru.netology.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.springmvc.entity.Persons;
import ru.netology.springmvc.repository.MyRepository;

import java.util.List;

@Service
public class MyService {
    @Autowired
    MyRepository userRepository;

    public List<Persons> getPersonsByCity(String name) {
        return userRepository.getPersonsByCity(name);
    }

}