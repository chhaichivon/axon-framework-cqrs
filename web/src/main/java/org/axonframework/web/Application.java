package org.axonframework.web;

import org.axonframework.spring.config.EnableAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAxon
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
