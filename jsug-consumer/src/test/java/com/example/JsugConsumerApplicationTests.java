package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JsugConsumerApplication.class)
@WebIntegrationTest(randomPort = true)
public class JsugConsumerApplicationTests {

    @Value("${local.server.port}")
    int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void contextLoads() {
        assertThat(restTemplate.getForObject("http://localhost:" + port, String.class), is("Hello @11111111-1111-1111-1111-111111111111 from producer"));
    }

}
