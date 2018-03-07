package com.example.takahashi.springotamashi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig 
extends WebSecurityConfigurerAdapter 
{
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/webjars/**","/css/**","/fonts/**","/html/**","/images/**","/js/**", 
				"/h2-console/**",
				//for spring-fox
				"/swagger-resources/**",
	            "/swagger-ui.html",
	            "/v2/api-docs",
	            "/v2/api-docs.json");
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
//		.authorizeRequests()
//        // 1
//        .requestMatchers(EndpointRequest.to("status", "info"))
//            .permitAll()
//        // 2
//        .requestMatchers(EndpointRequest.toAnyEndpoint())
//            .hasRole("ACTUATOR")
//        // 3 
//        .requestMatchers(StaticResourceRequest.toCommonLocations())
//            .permitAll()
//        // 4
//        .antMatchers("/**")
//            .hasRole("USER")
//        .and()
		.authorizeRequests()
		.antMatchers("status","info","env")
		.permitAll()
		.anyRequest()
		.hasRole("ACTUATOR")
//		.anyRequest().authenticated()
		.and()
		.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/loginForm")
			.permitAll()
			.usernameParameter("username")
            .passwordParameter("password")
			.failureForwardUrl("/loginForm?error")
			.defaultSuccessUrl("/hellocontroller",true)
			.and()
		.logout()
			.logoutUrl("/logout")
			.permitAll()
			.logoutSuccessUrl("/loginForm")
			.deleteCookies("JSESSIONID").invalidateHttpSession(true);
	}
	
	@Bean
	public UserDetailsService userDetailsService()  {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.roles("USER")
				.build());
		manager.createUser(User.withDefaultPasswordEncoder().
				username("admin").
				password("admin").
				roles("USER","ADMIN").
				build());
		return manager;
	}
	
}