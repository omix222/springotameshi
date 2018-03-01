package com.example.takahashi.springotamashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class AppConfiguration {
//	@Bean
	  public StubLoggingFilter requestLoggingFilter() {
		StubLoggingFilter filter = new StubLoggingFilter();
	    return filter;
	  }
}
