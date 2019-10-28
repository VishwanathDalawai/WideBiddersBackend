package com.widebidders.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.widebidders.controllers", "com.widebidders.models.service", "com.widebidders.models.db" })
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
	    logger.info("Inside main");
		SpringApplication.run(Main.class, args);
	}
}
