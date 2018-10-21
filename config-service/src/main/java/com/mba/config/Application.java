package com.mba.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 * @author MBA
 *
 * @EnableConfigServer: enables the service as a Spring Cloud Config service
 */
@SpringBootApplication
@EnableConfigServer
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
