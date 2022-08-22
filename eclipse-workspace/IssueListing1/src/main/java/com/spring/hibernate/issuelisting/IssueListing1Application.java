package com.spring.hibernate.issuelisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IssueListing1Application {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(IssueListing1Application.class, args);
		
	}
}