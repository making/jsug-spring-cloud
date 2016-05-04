package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class JsugProducerApplication {
	UUID id = UUID.randomUUID();

	@RequestMapping(path = "/")
	String hello() {
		return "Hello @" + id;
	}

	public static void main(String[] args) {
		SpringApplication.run(JsugProducerApplication.class, args);
	}
}
