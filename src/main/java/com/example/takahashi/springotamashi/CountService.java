package com.example.takahashi.springotamashi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CountService {
	@Autowired
	private CounterRepository counterRepository;

	private static final Logger logger = LoggerFactory.getLogger(CountService.class);

	public Integer getCurrentCount(String id) {
		Optional<Counter> currentCount =  counterRepository.findById(id);
		if(currentCount.isPresent()) {
			return currentCount.get().getCount();
		}
		logger.info("error : counterRepository.findById:"+id);
		return -1;
	}
	@Transactional(value=TxType.REQUIRED)
	public Integer updateCount(String id) {
		Optional<Counter> currentCount =  counterRepository.findById(id);
		if(currentCount.isPresent()) {
			Counter current = currentCount.get();
			current.setCount(current.getCount() + 1);
			counterRepository.saveAndFlush(current);
		}
		logger.info("error : counterRepository.findById:"+id);
		return getCurrentCount(id);
	}
	
	@Transactional(value=TxType.REQUIRES_NEW)
	public Integer updateCountReqNew(String id) {
		Optional<Counter> currentCount =  counterRepository.findById(id);
		if(currentCount.isPresent()) {
			Counter current = currentCount.get();
			current.setCount(current.getCount() + 1);
			counterRepository.saveAndFlush(current);
		}
		logger.info("error : counterRepository.findById:"+id);
		return getCurrentCount(id);
	}
	
	@Transactional
	public Integer updateCountFail(String id) {
		Optional<Counter> currentCount =  counterRepository.findById(id);
		if(currentCount.isPresent()) {
			Counter current = currentCount.get();
			current.setCount(current.getCount() + 1);
			counterRepository.saveAndFlush(current);
		}
		logger.info("error : counterRepository.findById:"+id);
		throw new RuntimeException(" throw excetption !!!");
	}
}
