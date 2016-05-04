package com.example;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import org.junit.Before;

import java.util.UUID;

public class MvcTest {

    @Before
    public void setup() {
        JsugProducerApplication app = new JsugProducerApplication();
        // workaround for https://github.com/Codearte/accurest/issues/263
        app.id = UUID.fromString("11111111-1111-1111-1111-111111111111");
        RestAssuredMockMvc.standaloneSetup(app);
    }

}
