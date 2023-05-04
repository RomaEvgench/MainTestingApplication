package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Question;
import ru.testingapplication.MainTestingApplication.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class QuestionService {
    private final QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public Question findOne(int id){
        Optional<Question> foundQuestion = questionRepository.findById(id);
        return foundQuestion.orElse(null);
    }

    @Transactional
    public void save(Question question){
        questionRepository.save(question);
    }

    @Transactional
    public void update(int id, Question updatedQuestion){
        //updatedPerson.setId(id);
        questionRepository.save(updatedQuestion);
    }

    @Transactional
    public void delete(int id){
        questionRepository.deleteById(id);
    }
}
