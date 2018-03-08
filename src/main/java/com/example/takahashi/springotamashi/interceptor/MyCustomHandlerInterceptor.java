package com.example.takahashi.springotamashi.interceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.annotation.CacheAnnotationParser;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyCustomHandlerInterceptor extends HandlerInterceptorAdapter {

	  @Override
	  public void postHandle(HttpServletRequest request
	                       , HttpServletResponse response
	                       , Object handler
	                       , ModelAndView modelAndView) throws Exception {
	    if (!(handler instanceof HandlerMethod)) {
	      return;
	    }

	    HandlerMethod handlerMethod = (HandlerMethod) handler;

	    if (handlerMethod.hasMethodAnnotation(NoCacheAnnotation.class)) {
	      addNoCacheHeaders(response);

	    } else if (handlerMethod.hasMethodAnnotation(CacheAnnotation.class)) {
	      CacheAnnotationParser annotation = (CacheAnnotationParser) handlerMethod.getMethodAnnotation(CacheAnnotation.class);
	      int maxAge = (int) AnnotationUtils.getValue((Annotation) annotation, "maxAge");
	      addCacheHeaders(response, maxAge);
	    }

	  }

	  private void addNoCacheHeaders(HttpServletResponse response) {
	    response.addHeader("Cache-Control", "no-store");
	  }

	  private void addCacheHeaders(HttpServletResponse response, int maxAge) {
	    response.addHeader("Cache-Control", "max-age=" + maxAge);
	    //response.addDateHeader("Expires", new Date().getTime() + (long)(maxAge * 1000));
	  }

	}