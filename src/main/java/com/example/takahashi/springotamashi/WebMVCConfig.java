package com.example.takahashi.springotamashi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.takahashi.springotamashi.interceptor.MyCustomHandlerInterceptor;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebMVCConfig 
extends WebMvcConfigurerAdapter {
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new MyCustomHandlerInterceptor())
	      .addPathPatterns("/**")
	      .excludePathPatterns("/static/**");
	  }
}