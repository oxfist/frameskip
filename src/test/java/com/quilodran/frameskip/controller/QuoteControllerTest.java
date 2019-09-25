package com.quilodran.frameskip.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuoteController.class)
class QuoteControllerTest {

  @Autowired
  private transient MockMvc mvc;

  @Test
  @DisplayName("GET /quote - Success")
  @SuppressWarnings("PMD.LawOfDemeter")
  public void shouldReturnSolidSnakeQuote() throws Exception {
    mvc.perform(get("/quote"))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content()
            .json("{ \"quote\": \"Do you think love can bloom, even on the battlefield?\" }"))
        .andExpect(status().isOk());
  }
}
