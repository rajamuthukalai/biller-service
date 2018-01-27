package com.biller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
@EnableDiscoveryClient
public class BillerServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BillerServiceApplication.class, args);
	}
}

@RestController
@RequestScope
class DefaultController {
	
	@Value("${message:default message}")
	private String message;
	
	@GetMapping("/message")
	public String message() {
		return message;
	}
}