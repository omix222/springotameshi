package com.example.takahashi.springotamashi;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSourceSample {
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    // Set a property file on the class path.
	    messageSource.setBasename("messages");
	    // Set UTF-8 as a default encoding code
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
}
