package org.readBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(basePackages = {
		"org.readBook.service",
		"org.readBook.service.model",
		"org.readBook.controller",
		"org.readBook.controller.webUi",
		"org.readBook.dao.jpa.entity",
		"org.readBook.dao.jpa.repository"})

// TODO : Combine all Components
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
