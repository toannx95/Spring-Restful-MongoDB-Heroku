package com.spring.controller;

import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("wakeup")
public class WakeUpController {

	private static final Logger LOGGER = Logger.getLogger(WakeUpController.class.getName());

	@Scheduled(cron = "${scheduler.cron-every-5-mins}")
	@GetMapping
	private String wakeup() {
		LOGGER.info("wakeup");
		final String uri = "https://nguyen-xuan-toan.herokuapp.com/";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

}
