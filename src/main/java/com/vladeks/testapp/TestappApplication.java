package com.vladeks.testapp;

import com.vladeks.testapp.repository.QuestionRepository;
import com.vladeks.testapp.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestappApplication {

	@Autowired
	QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestappApplication.class, args);
	}


}
