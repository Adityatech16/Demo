package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		System.out.println("Employee CRUD");
		SpringApplication.run(EmployeeCrudApplication.class, args);
	}

}
