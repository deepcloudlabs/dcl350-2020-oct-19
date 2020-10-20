package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;
import com.example.lottery.service.ServiceQuality;

@Service
public class SimpleLotteryService implements LotteryService {
	@Autowired 
	@ServiceQuality(QualityLevel.SECURE)
	private RandomNumberService randomNumberService;
	
	@Override
	public List<List<Integer>> draw(int column) {
		System.err.println(randomNumberService.getClass().getName());
		return IntStream.range(0, column)
				   .mapToObj(i -> draw())
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
}
