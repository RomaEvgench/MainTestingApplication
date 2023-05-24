package ru.testingapplication.MainTestingApplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.testingapplication.MainTestingApplication.config.PasswordEncoderConfig;
import ru.testingapplication.MainTestingApplication.models.Person;
import ru.testingapplication.MainTestingApplication.models.RegistrationRequest;
import ru.testingapplication.MainTestingApplication.services.CourseService;
import ru.testingapplication.MainTestingApplication.services.PeopleService;

@Controller
public class RegistrationController {
    private final PeopleService peopleService;

    private final CourseService courseService;
    private final PasswordEncoderConfig passwordEncoderConfig;
    public RegistrationController(PeopleService peopleService, CourseService courseService, PasswordEncoderConfig passwordEncoderConfig) {
        this.peopleService = peopleService;
        this.courseService = courseService;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (peopleService.existsByUsername(registrationRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }
        PasswordEncoder passwordEncoder = passwordEncoderConfig.passwordEncoder();
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        Person person = new Person();
        person.setUsername(registrationRequest.getUsername());
        person.setPassword(encodedPassword);
        person.setPatronymic(registrationRequest.getPatronymic());
        person.setLast_name(registrationRequest.getLastName());
        person.setFirst_name(registrationRequest.getFirstName());
        person.setRole(registrationRequest.getRole());
        person.setCourse(courseService.findOne(registrationRequest.getCourseId()));
        peopleService.save(person);

        return ResponseEntity.ok("User registered successfully");
    }
}
