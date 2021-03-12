package com.mabshura.FirstSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringBootApplication {

	public static void main(String[] args) {
		System.out.println("Start...");
		SpringApplication.run(FirstSpringBootApplication.class, args);
		System.out.println("End ...");
	}

}
