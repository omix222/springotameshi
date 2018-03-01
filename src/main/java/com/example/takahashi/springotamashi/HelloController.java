package com.example.takahashi.springotamashi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.MessageSource;

@Controller
@RequestMapping("/hellocontroller")
public class HelloController {

	@Value("${hoge:hogehoge}")
	String hoge;
	
	// Massageの取得
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	HelloService helloService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String hello() {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String username = "default";
//		if (principal instanceof UserDetails) {
//			username = ((UserDetails) principal).getUsername();
//		} else {
//			username = principal.toString();
//		}
//		logger.info("User : " + username);
//		logger.info("${hoge}:" + hoge);
//		String message = messageSource.getMessage("welcome.message", new String[]{"hogehoge"}, Locale.JAPANESE);
//		logger.info(message);
		logger.info("call helloService :"+helloService.doService());
		return "hellospringmvc";
	}
}
