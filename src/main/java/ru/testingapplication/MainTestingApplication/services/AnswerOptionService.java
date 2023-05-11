package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.AnswerOption;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.repositories.AnswerOptionRepository;
import ru.testingapplication.MainTestingApplication.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AnswerOptionService {
    private final AnswerOptionRepository answerOptionRepository;
    @Autowired
    public AnswerOptionService(AnswerOptionRepository answerOptionRepository) {
        this.answerOptionRepository = answerOptionRepository;
    }

    public List<AnswerOption> findAll(){
        return answerOptionRepository.findAll();
    }

    public AnswerOption findOne(int id){
        Optional<AnswerOption> foundPerson = answerOptionRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(AnswerOption answerOption){
        answerOptionRepository.save(answerOption);
    }

    @Transactional
    public void update(int id, AnswerOption updatedAnswerOption){
        //updatedPerson.setId(id);
        answerOptionRepository.save(updatedAnswerOption);
    }

    @Transactional
    public void delete(int id){
        answerOptionRepository.deleteById(id);
    }

}
