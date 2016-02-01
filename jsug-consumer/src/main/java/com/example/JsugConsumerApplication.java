package com.example;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class JsugConsumerApplication {
	@Autowired
	EurekaClient eurekaClient;

	@RequestMapping(path = "/")
	String hello() {
		String url = eurekaClient.getNextServerFromEureka("jsug-producer", false).getHomePageUrl();
		String res = new RestTemplate().getForObject(url, String.class);
		return res + " from " + url;
	}

	public static void main(String[] args) {
		SpringApplication.run(JsugConsumerApplication.class, args);
	}
}
