package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.Test;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findByCourse(Course course);
}
