package ru.testingapplication.MainTestingApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.Question;
import ru.testingapplication.MainTestingApplication.models.Test;
import ru.testingapplication.MainTestingApplication.services.PeopleService;
import ru.testingapplication.MainTestingApplication.services.TestService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;
    private final TestService testService;

    @Autowired
    public PeopleController(PeopleService peopleService, TestService testService) {
        this.peopleService = peopleService;
        this.testService = testService;
    }

    @GetMapping("/GetPeople")
    public Map<String, List<?>> GetPeople() {
        List<Person> people = peopleService.findAll();
        Map<String, List<?>> data = new HashMap<>();
        data.put("people", people);
        return data;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id) {
        Test test = testService.findOne(id);
        List<Question> questions = test.getQuestions();
        return "people/show";
    }
}
