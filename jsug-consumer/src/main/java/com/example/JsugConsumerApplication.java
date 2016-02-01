package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableZuulProxy
@RestController
public class JsugConsumerApplication {
    @Autowired
    DemoService demoService;

    @RequestMapping(path = "/")
    String hello() {
        String res = demoService.getResponse();
        return res + " from producer";
    }

    public static void main(String[] args) {
        SpringApplication.run(JsugConsumerApplication.class, args);
    }
}

@Component
class DemoService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultResponse")
    public String getResponse() {
        return restTemplate.getForObject("http://jsug-producer", String.class);
    }

    public String defaultResponse() {
        return "Not Available now";
    }
}