package com.quilodran.frameskip.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class QuoteControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GET /quote - Success")
    public void should_return_solid_snake_quote() throws Exception {
        mvc.perform(get("/quote"))
                .andExpect(status().isOk());
    }
}
