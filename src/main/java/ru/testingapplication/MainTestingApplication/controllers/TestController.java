package ru.testingapplication.MainTestingApplication.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testingapplication.MainTestingApplication.models.AnswerOption;
import ru.testingapplication.MainTestingApplication.models.Question;
import ru.testingapplication.MainTestingApplication.models.Test;
import ru.testingapplication.MainTestingApplication.services.TestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {


    public class MyEntity {
        private int id;
        private String testName;
        private List<ResponseEntity> responseEntities;

        public MyEntity(int id, String testName, List<ResponseEntity> responseEntities ) {
            this.testName = testName;
            this.id = id;
            this.responseEntities = responseEntities;
        }
    }

    public class ResponseEntity {
        private int id;
        private String questionText;
        private int questionCost;
        private List<ResponseEntityOptions> responseEntityOptions;

        public ResponseEntity(int id, String text, int cost, List<ResponseEntityOptions> responseEntityOptions  ) {
            this.questionText = text;
            this.id = id;
            this.responseEntityOptions = responseEntityOptions;
            this.questionCost = cost;
        }

    }

    public class ResponseEntityOptions {
        private int id;
        private String optionText;
        private Boolean isRight;

        public ResponseEntityOptions(int id, String optionText, Boolean isRight) {
            this.id = id;
            this.optionText = optionText;
            this.isRight = isRight;
        }

    }


    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/GetQuestions")
    public String show(@PathVariable("id") int id) throws JsonProcessingException {
        Test test = testService.findOne(id);
        List<Question> questions = test.getQuestions();
        List<ResponseEntity> questionEntities = new ArrayList<>();
        for(Question question: questions){
            List<ResponseEntityOptions> optionEntityList = new ArrayList<>();
            List<AnswerOption> options = question.getOptions();
            for(AnswerOption option: options){
                optionEntityList.add(new ResponseEntityOptions(option.getId(), option.getOption_text(), option.getIs_right()));
            }
            questionEntities.add(new ResponseEntity(question.getId(), question.getQuestionText(), question.getQuestionCost(), optionEntityList));
        }
        MyEntity testEntity = new MyEntity(id, test.getTestName(), questionEntities);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(testEntity);
        return json;
    }


}
