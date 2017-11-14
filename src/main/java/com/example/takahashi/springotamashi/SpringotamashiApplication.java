package com.example.takahashi.springotamashi;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringotamashiApplication {
	@PostConstruct
	public void before() {
		System.out.println("use run run");
		Employee emp = new Employee("u001","taka",33);
		repo.save(emp);
		
	}
	@Autowired
	EmployeeRepository repo;
	public static void main(String[] args) {
		
		SpringApplication.run(SpringotamashiApplication.class, args);
	}
}
