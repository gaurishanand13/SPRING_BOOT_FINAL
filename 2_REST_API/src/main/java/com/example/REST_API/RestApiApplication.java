package com.example.REST_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring will create objects of those classes automatically which are having @component annotation
 * over it directly or indirectly
 */
@SpringBootApplication
public class RestApiApplication {
	// By default port is 8080, but i have changed port to 7000 --> you can refer to application.properties file.
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
