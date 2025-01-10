package ru.netology.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.netology.springmvc.entity.PK;
import ru.netology.springmvc.entity.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PK> {

    @Query("select p from Persons p where upper(p.cityOfLiving) like upper(:cityOfLiving)")
    List<Persons> findByCity(@Param("cityOfLiving") String cityOfLiving);

    @Query("select p from Persons p where p.pk.age < :age order by p.pk.age")
    List<Persons> findByAge(@Param("age") int age);

    @Query("select p from Persons p where p.pk.name = :name and p.pk.surname = :surname")
    Optional<Persons> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}