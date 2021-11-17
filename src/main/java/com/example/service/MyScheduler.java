package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MyScheduler {
	
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void StartScheduler() {
		System.out.println("Cron is hitting");
	}
}
