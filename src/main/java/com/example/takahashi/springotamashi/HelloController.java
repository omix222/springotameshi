package com.example.takahashi.springotamashi;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;

@Service
@RequestMapping("/hello")
public class HelloController {

	@Value("${hoge:hogehoge}")
	String hoge;

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String hello() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "default";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		logger.info("User : " + username);
		logger.info("${hoge}:" + hoge);
		return "hellospringmvc";
	}
}
