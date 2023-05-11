package ru.testingapplication.MainTestingApplication.controllers;

import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testingapplication.MainTestingApplication.models.Course;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.Result;
import ru.testingapplication.MainTestingApplication.models.Test;
import ru.testingapplication.MainTestingApplication.services.CourseService;
import ru.testingapplication.MainTestingApplication.services.PeopleService;
import ru.testingapplication.MainTestingApplication.services.ResultService;
import ru.testingapplication.MainTestingApplication.services.TestService;

import java.util.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    public class ResponseEntityStudent {
        private String FullName;
        private Map <String, Integer> results;
        public ResponseEntityStudent(String FullName, Map <String, Integer> results) {
            this.FullName = FullName;
            this.results = results;
        }

        // геттеры и сеттеры для всех строк
    }

    public class ResponseEntityTeacher {
        private String FullName;
        private Map <Map<Integer,String>, Map<Integer,String>> studentsByCourses;
        private Map <Map<Integer,String>, Map<Integer,String>> testsByCourse;
        public ResponseEntityTeacher(String FullName, Map <Map<Integer,String>, Map<Integer,String>> studentsByCourses,
                                     Map <Map<Integer,String>, Map<Integer,String>> testsByCourse) {
            this.FullName = FullName;
            this.studentsByCourses = studentsByCourses;
            this.testsByCourse = testsByCourse;
        }

        // геттеры и сеттеры для всех строк
    }
    private final PeopleService peopleService;
    private final ResultService resultService;
    private final TestService testService;
    private final CourseService courseService;

    @Autowired
    public PeopleController(PeopleService peopleService, ResultService resultService, TestService testService, CourseService courseService) {
        this.peopleService = peopleService;
        this.resultService = resultService;
        this.testService = testService;
        this.courseService = courseService;
    }

    @GetMapping("/GetPeople")
    public Map<String, List<?>> GetPeople() {
        List<Person> people = peopleService.findAll();
        Map<String, List<?>> data = new HashMap<>();
        data.put("people", people);
        return data;
    }



    @GetMapping("/PersonalAccount")
    public String show(@PathVariable("id") int id) throws JsonProcessingException {
        Person person = peopleService.findOne(id);
        ObjectMapper objectMapper = new ObjectMapper();
        if (person.getRole().equals("role_student")) {
            List<Result> results = resultService.findByPerson(person);
            Map<String, Integer> map = new HashMap<>();
            for (Result result : results) {
                String testName = result.getTest().getTestName();
                Integer score = result.getScore();
                map.put(testName, score);
            }
            ResponseEntityStudent responseEntity = new ResponseEntityStudent(person.getFullName(), map);
            String json = objectMapper.writeValueAsString(responseEntity);
            return json;
        } else {
            //(person.getRole().equals("role_teacher"))
            List<Course> courses = courseService.findAll();
            Map<Integer, String> studentsMap = new HashMap<>();
            Map<Integer, String> testsMap = new HashMap<>();
            Map <Map<Integer,String>, Map<Integer,String>> studentsByCourses = new HashMap<>();
            Map <Map<Integer,String>, Map<Integer,String>> testsByCourse = new HashMap<>();

            //Map<Integer, String> courseMap = new HashMap<>();
            for(Course course: courses){
                Map<Integer, String> courseMap = new HashMap<>();
                List<Person> students = peopleService.findByCourse(course);
                List<Test> tests = testService.findByCourse(course);
                for(Person student: students){
                    Integer studentId = student.getId();
                    String fullName = student.getFullName();
                    studentsMap.put(studentId, fullName);
                }
                for(Test test: tests){
                    Integer studentId = test.getId();
                    String testName = test.getTestName();
                    testsMap.put(studentId, testName);
                }
                courseMap.put(course.getId(), course.getName());
                studentsByCourses.put(courseMap, studentsMap);
                testsByCourse.put(courseMap, testsMap);
            }
            ResponseEntityTeacher responseEntity = new ResponseEntityTeacher(person.getFullName(), studentsByCourses, testsByCourse);
            String json = objectMapper.writeValueAsString(responseEntity);
            return json;

        }

    }

    @GetMapping("/Update")
    public String update(@PathVariable("id") int id, @PathVariable("first_name") String first_name, @PathVariable("last_name") String last_name,
                            @PathVariable("patronymic") String patronymic, @PathVariable("username") String username, @PathVariable("course_id") int course_id) {
        Person person = peopleService.findOne(id);
        Course course = courseService.findOne(course_id);
        person.setCourse(course);
        person.setFirst_name(first_name);
        person.setLast_name(last_name);
        person.setPatronymic(patronymic);
        person.setUsername(username);
        peopleService.update(person);
        String string = "";
        return string;
    }
    @GetMapping("/Delete")
    public String delete(@PathVariable("id") int id) {
        peopleService.delete(id);
        String string = "";
        return string;
    }


}
