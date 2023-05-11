package ru.testingapplication.MainTestingApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testingapplication.MainTestingApplication.models.AnswerOption;
import ru.testingapplication.MainTestingApplication.models.Question;
import ru.testingapplication.MainTestingApplication.models.Test;
import ru.testingapplication.MainTestingApplication.services.QuestionService;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/GetAnswerOptions")
    public List<AnswerOption> show(@PathVariable("id") int id) {
        Question question = questionService.findOne(id);
        List<AnswerOption> options = question.getOptions();
        return options;
    }


}
