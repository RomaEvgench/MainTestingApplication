package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.Test;
import ru.testingapplication.MainTestingApplication.repositories.TestRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TestService {

    private final TestRepository testRepository;
    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll(){
        return testRepository.findAll();
    }

    public Test findOne(int id){
        Optional<Test> foundTest = testRepository.findById(id);
        return foundTest.orElse(null);
    }

    @Transactional
    public void save(Test test){
        testRepository.save(test);
    }

    @Transactional
    public void update(int id, Test updatedTest){
        //updatedPerson.setId(id);
        testRepository.save(updatedTest);
    }

    public List<Test> findByCourse(Course course){
        return testRepository.findByCourse(course);
    }

    @Transactional
    public void delete(int id){
        testRepository.deleteById(id);
    }
}
