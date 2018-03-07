package com.example.takahashi.springotamashi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class HeadService {
	@Autowired
	private CountService countService;

	@Transactional
	public Integer nestService(String id) {
		countService.updateCountReqNew("001");
		Integer result = countService.updateCountFail("001");
		return result;
	}
}
