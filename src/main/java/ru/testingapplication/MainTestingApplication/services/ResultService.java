package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Result;
import ru.testingapplication.MainTestingApplication.repositories.ResultRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ResultService {

    private final ResultRepository resultRepository;
    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> findAll(){
        return resultRepository.findAll();
    }

    public Result findOne(int id){
        Optional<Result> foundResult = resultRepository.findById(id);
        return foundResult.orElse(null);
    }

    @Transactional
    public void save(Result result){
        resultRepository.save(result);
    }

    @Transactional
    public void update(int id, Result updatedResult){
        //updatedPerson.setId(id);
        resultRepository.save(updatedResult);
    }

    @Transactional
    public void delete(int id){
        resultRepository.deleteById(id);
    }
}
