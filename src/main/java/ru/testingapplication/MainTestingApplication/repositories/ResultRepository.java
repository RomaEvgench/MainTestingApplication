package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.Result;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{
    List<Result> findByPerson(Person person);
}
