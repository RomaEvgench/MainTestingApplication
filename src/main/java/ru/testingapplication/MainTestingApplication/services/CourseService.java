package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.repositories.CourseRepository;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Course findOne(int id){
        Optional<Course> foundCourse = courseRepository.findById(id);
        return foundCourse.orElse(null);
    }

    @Transactional
    public void save(Course course){
        courseRepository.save(course);
    }

    @Transactional
    public void update(int id, Course updatedCourse){
        //updatedPerson.setId(id);
        courseRepository.save(updatedCourse);
    }

    @Transactional
    public void delete(int id){
        courseRepository.deleteById(id);
    }
}
