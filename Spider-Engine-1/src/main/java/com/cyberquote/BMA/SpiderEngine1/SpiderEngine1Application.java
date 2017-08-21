package com.cyberquote.BMA.SpiderEngine1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpiderEngine1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpiderEngine1Application.class, args);
	}
}
