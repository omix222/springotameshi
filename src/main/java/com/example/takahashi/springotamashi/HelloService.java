package com.example.takahashi.springotamashi;

import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HelloService {

	
	private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

	public String doService() {
		logger.info("doing HelloService");
		return "done Service";
	}
}
