package com.champs.restNuvem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestNuvemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestNuvemApplication.class, args);
		System.out.println("=========\nSpring ativo!\n=========");
		System.out.println("Acesse: http://localhost:8080/h2-console");
	}

}
