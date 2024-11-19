package com.etutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

public class EtutorSpringBackendMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtutorSpringBackendMongoApplication.class, args);
	}

}
