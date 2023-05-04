package ru.testingapplication.MainTestingApplication.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.testingapplication.MainTestingApplication.security.AuthProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthProvider authProvider;
    @Autowired
    public SecurityConfig(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider);

    }

}
