package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {

}
