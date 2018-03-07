package com.example.takahashi.springotamashi;



import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SpringotamashiApplication {
	@Autowired
	CounterRepository countRepo;
	@PostConstruct
	public void before() {
		System.out.println("use run run");
//		Employee emp = new Employee("u001","taka",33);
//		repo.save(emp);
//		Counter count = new Counter();
//		count.setId("001");
//		count.setCount(0);
//		countRepo.save(count);
		
	}
	//@Autowired
	EmployeeRepository repo;
	public static void main(String[] args) {
		//PCF上でGWTにならないように固定化
			TimeZone.setDefault(TimeZone.getTimeZone("JST"));
		
		SpringApplication.run(SpringotamashiApplication.class, args);
	}
}
