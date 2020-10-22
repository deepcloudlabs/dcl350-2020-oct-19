package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.service.CrmService;
import com.example.service.LotteryService;

@Service
public class StudyClientSideLoadBalancing4 {
	@Autowired private LotteryService lotteryService;
	@Autowired private CrmService crmService;
	
	@Scheduled(fixedRate = 1_000)
	public void callLotteryService() {
		System.err.println(" (#4) : "+lotteryService.getir(10));
	}
	
	@Scheduled(fixedRate = 2_000)
	public void callCrmService() {
		System.err.println("crmSrv : "+crmService.findCustomer("96593328522"));
	}
}
