package com.mba.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RefreshScope
public class Application {

	/**
	 * get RestTemplate method build to use a Ribbon-aware RestTemplate class.
	 * 
	 * @LoadBalanced: annotation tells Spring Cloud to create a Ribbon backed
	 *                RestTemplate class.
	 * @return RestTemplate instance. 
	 */
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}