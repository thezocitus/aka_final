package com.aka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.aka.app"})
public class AkaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkaFinalApplication.class, args);
	}

}
