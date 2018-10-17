package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringRestMongoHerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestMongoHerokuApplication.class, args);
	}
}
