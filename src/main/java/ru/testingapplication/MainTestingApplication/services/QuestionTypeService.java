package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.QuestionType;
import ru.testingapplication.MainTestingApplication.repositories.QuestionTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class QuestionTypeService {
    private final QuestionTypeRepository questionTypeRepository;
    @Autowired
    public QuestionTypeService(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    public List<QuestionType> findAll(){
        return questionTypeRepository.findAll();
    }

    public QuestionType findOne(int id){
        Optional<QuestionType> foundQuestionType = questionTypeRepository.findById(id);
        return foundQuestionType.orElse(null);
    }

    @Transactional
    public void save(QuestionType questionType){
        questionTypeRepository.save(questionType);
    }

    @Transactional
    public void update(int id, QuestionType updatedQuestionType){
        //updatedPerson.setId(id);
        questionTypeRepository.save(updatedQuestionType);
    }

    @Transactional
    public void delete(int id){
        questionTypeRepository.deleteById(id);
    }
}
