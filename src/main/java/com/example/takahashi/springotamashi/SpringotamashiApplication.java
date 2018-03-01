package com.example.takahashi.springotamashi;



import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;


@SpringBootApplication
//@Import(SpringDataRestConfiguration.class)
public class SpringotamashiApplication {
	//@PostConstruct
	public void before() {
		System.out.println("use run run");
		Employee emp = new Employee("u001","taka",33);
		repo.save(emp);
		
	}
	//@Autowired
	EmployeeRepository repo;
	public static void main(String[] args) {
		//PCF上でGWTにならないように固定化
			TimeZone.setDefault(TimeZone.getTimeZone("JST"));
		
		SpringApplication.run(SpringotamashiApplication.class, args);
	}
}
