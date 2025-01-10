package ru.netology.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.netology.springmvc.entity.PK;
import ru.netology.springmvc.entity.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PK> {

    List<Persons> findByCityOfLivingLikeIgnoreCase(String cityOfLiving);

    List<Persons> findByPk_AgeLessThanOrderByPk_AgeAsc(int age);

    Optional<Persons> findByPk_NameAndPk_Surname(String name, String surname);
}