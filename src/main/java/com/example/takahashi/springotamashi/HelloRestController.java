package com.example.takahashi.springotamashi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/hello")
public class HelloRestController {

	private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);

	@RequestMapping(method = RequestMethod.GET)
	public Employee hello() {
		Employee emp = new Employee();
		emp.setAge(11);
		emp.setId("id001");
		emp.setName("takahashi");
		logger.info("restapi");
		return emp;
	}
}
