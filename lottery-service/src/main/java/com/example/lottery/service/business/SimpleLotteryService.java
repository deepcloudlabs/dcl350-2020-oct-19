package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;
import com.example.lottery.service.ServiceQuality;

@Service
public class SimpleLotteryService implements LotteryService {
	@Autowired 
	//@ServiceQuality(QualityLevel.SECURE)
	private RandomNumberService randomNumberService;
	private AtomicInteger counter = new AtomicInteger();
	private int numberOfImps;
	@Autowired 
	private List<RandomNumberService> services;
	
	@PostConstruct
	public void init() {
		numberOfImps = services.size();
	    services.stream()
	            .map(Object::getClass)
	            .map(Class::getName)
	            .forEach(System.err::println);	
	}
	
	@Override
	public List<List<Integer>> draw(int column) {
		System.err.println(randomNumberService.getClass().getName());
		return IntStream.range(0, column)
				   .mapToObj(i -> rrDraw())
				   .collect(Collectors.toList());
	}
	
	private List<Integer> draw(){
		return IntStream.generate( () -> randomNumberService.generate(1,49))
		        .distinct()
		        .limit(6)
		        .sorted()
		        .boxed()
		        .collect(Collectors.toList());
	}
	private List<Integer> rrDraw(){
		var randomSrv = services.get(counter.getAndIncrement() % numberOfImps);
		return IntStream.generate( () -> randomSrv.generate(1,49))
				.distinct()
				.limit(6)
				.sorted()
				.boxed()
				.collect(Collectors.toList());
	}
}
