package com.quilodran.frameskip.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quote", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class QuoteController {
    @GetMapping
    public String getQuote() {
        return "{ \"quote\": \"Kept you waiting, huh?\" }";
    }
}
