package com.example.mohamed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MohamedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohamedApplication.class, args);
		message();
	}

	public static void message() {
		System.out.println("Hello, World!");
		
	}
}
