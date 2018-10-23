package com.mba.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author MBA
 *
 * @EnableEurekaServer: Annotation to activate Eureka Server related
 *                      configuration
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
