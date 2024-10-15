package com.example.spring_cloud_config_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClient {

	@Value("${app.greeting}")
	private String greetingMessage;

	@GetMapping("/greeting")
    public String greeting() {
        return "Hello from Config Client! The current value of 'greeting.message' is: " + greetingMessage;
    }

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}

}
