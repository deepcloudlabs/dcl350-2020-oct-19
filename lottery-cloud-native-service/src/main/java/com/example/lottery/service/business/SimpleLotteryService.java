package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberService;

@Service
@RefreshScope
public class SimpleLotteryService implements LotteryService {
	@Autowired 
	private RandomNumberService randomNumberService;
	@Value("${lottery.max}")
	private int lotteryMax;
	@Value("${lottery.size}")
	private long lotterySize;
	
	@Override
	public List<List<Integer>> draw(int column) {
		System.err.println(randomNumberService.getClass().getName());
		return IntStream.range(0, column)
				   .mapToObj(i -> draw())
				   .collect(Collectors.toList());
	}
	
	private List<Integer> draw(){
		return IntStream.generate( () -> randomNumberService.generate(1,lotteryMax))
		        .distinct()
		        .limit(lotterySize)
		        .sorted()
		        .boxed()
		        .collect(Collectors.toList());
	}

}
