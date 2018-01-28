package com.sannu.billerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class BillerServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BillerServiceApplication.class, args);
	}
}

@RestController
@RefreshScope
class DefaultController {
	
	@Value("${message:default biller service}")
	private String message;
	
	@GetMapping("/message")
	public String message() {
		return message;
	}
}