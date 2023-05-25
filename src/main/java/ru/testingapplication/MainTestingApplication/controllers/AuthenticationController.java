package ru.testingapplication.MainTestingApplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.testingapplication.MainTestingApplication.models.AuthenticationRequest;
import ru.testingapplication.MainTestingApplication.models.AuthenticationResponse;
import ru.testingapplication.MainTestingApplication.security.PersonDetails;
import ru.testingapplication.MainTestingApplication.services.JwtUtil;
import ru.testingapplication.MainTestingApplication.services.PersonDetailsService;

@Controller
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final PersonDetailsService personDetailsService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, PersonDetailsService personDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.personDetailsService = personDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }

        final PersonDetails personDetails;
        try {
            personDetails = (PersonDetails) personDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
        } catch (UsernameNotFoundException e) {
            throw new Exception("User not found", e);
        }

        final String accessToken = jwtUtil.generateToken(personDetails.getUsername(), false);
        final String refreshToken = jwtUtil.generateToken(personDetails.getUsername(), true);

        return ResponseEntity.ok(new AuthenticationResponse(accessToken, refreshToken));
    }
}
