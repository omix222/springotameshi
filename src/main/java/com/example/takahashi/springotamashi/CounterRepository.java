package com.example.takahashi.springotamashi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, String>{
	
}
