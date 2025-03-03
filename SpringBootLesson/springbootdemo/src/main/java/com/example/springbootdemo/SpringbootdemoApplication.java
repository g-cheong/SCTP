package com.example.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootdemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringbootdemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
		System.out.println("My first SpringBoot app again");
		logger.info("starting springbootdemoApplication");
		logger.warn("Test warning");
		logger.error("Test error");
	}

	
}
