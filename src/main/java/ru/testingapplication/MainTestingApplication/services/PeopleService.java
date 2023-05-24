package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
         Optional<Person> foundPerson = peopleRepository.findById(id);
         return foundPerson.orElse(null);
    }

    public Optional<Person> findByUsername(String username){
        return peopleRepository.findByUsername(username);
    }

    public Boolean existsByUsername(String username){
        return peopleRepository.existsByUsername(username);
    }
    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(Person updatedPerson){
        //updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    public List<Person> findByCourse(Course course){
        return peopleRepository.findByCourse(course);
    }
    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
