package com.shortjam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class ShortJamApplication {

	public static void main(String[] args) {
		System.err.println("LOGGING IS ACTUALLY WORKING!");
		SpringApplication.run(ShortJamApplication.class, args);
	}
}
