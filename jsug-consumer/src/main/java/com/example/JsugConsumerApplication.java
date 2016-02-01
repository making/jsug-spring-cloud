package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class JsugConsumerApplication {
	@Autowired
	DiscoveryClient discoveryClient;

	@RequestMapping(path = "/")
	String hello() {
		List<ServiceInstance> instances = discoveryClient.getInstances("jsug-producer");
		if (instances.isEmpty()) {
			return "No Service Registry!";
		}
		URI uri = instances.get(0).getUri();
		String res = new RestTemplate().getForObject(uri, String.class);
		return res + " from " + uri;
	}

	public static void main(String[] args) {
		SpringApplication.run(JsugConsumerApplication.class, args);
	}
}
