package ru.testingapplication.MainTestingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class MainTestingApplication {



	public static void main(String[] args) {
		SpringApplication.run(MainTestingApplication.class, args);
		String password = "12345qwerty";
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		System.out.println(encodedPassword);
		System.out.println(bCryptPasswordEncoder.encode("12345qwertyy"));
		System.out.println(bCryptPasswordEncoder.encode("1234qwerty"));

	}

}
