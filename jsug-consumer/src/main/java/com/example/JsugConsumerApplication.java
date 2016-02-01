package com.example;

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
    RestTemplate restTemplate;

    @RequestMapping(path = "/")
    String hello() {
        String res = restTemplate.getForObject("http://jsug-producer", String.class);
        return res + " from producer";
    }

    public static void main(String[] args) {
        SpringApplication.run(JsugConsumerApplication.class, args);
    }
}
