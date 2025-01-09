package ru.netology.springmvc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.springmvc.entity.Persons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MyRepository {

    @PersistenceContext
    private EntityManager manager;

    public List<Persons> getPersonsByCity(String city) {
        return manager.createQuery("select p from Persons p\n" +
                        "where p.city_of_living ILIKE :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}
