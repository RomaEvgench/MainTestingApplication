package ru.testingapplication.MainTestingApplication.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.testingapplication.MainTestingApplication.security.PersonDetails;

@Controller
public class start {
    @GetMapping("/hi")
    public String Start(){
        return "index";
    }

    @GetMapping("/")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        if(personDetails.getPerson().getRole().equals("role_student")){
            return "userPage";
        }else if(personDetails.getPerson().getRole().equals("role_teacher")){
            return "teacherPage";
        }else if(personDetails.getPerson().getRole().equals("role_admin")){
            return "adminPage";
        }


        return "index";
    }
}
