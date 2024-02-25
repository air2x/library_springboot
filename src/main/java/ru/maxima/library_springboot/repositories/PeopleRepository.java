package ru.maxima.library_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.library_springboot.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
