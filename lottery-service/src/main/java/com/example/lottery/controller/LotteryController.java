package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.LotteryService;

@RestController
@RequestScope
@RequestMapping("numbers")
@CrossOrigin
public class LotteryController {

	@Autowired private LotteryService lotteryService;

	// http://localhost:8001/lottery/api/v1/numbers?column=5
	@GetMapping(params = "column")
	public List<List<Integer>> getLotteryNumbers(
			@RequestParam(required = false, defaultValue = "10") int column){
		int x=3, y = 5;
		int z = x + y;
		x++;
		// z? UI -> Angular -> Reactive, React -> code -> Reactive, Vue -> Reactive
		return lotteryService.draw(column);
	}
}
