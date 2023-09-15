package com.aquariumetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AquariumetricsApplication {

	public static void main(String[] args) {

		SpringApplication.run(AquariumetricsApplication.class, args);
		System.out.println("Welcome to the Aquarium Metrics App");
	}

}
