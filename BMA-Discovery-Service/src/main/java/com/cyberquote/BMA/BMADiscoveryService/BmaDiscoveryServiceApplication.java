package com.cyberquote.BMA.BMADiscoveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BmaDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmaDiscoveryServiceApplication.class, args);
	}
}
