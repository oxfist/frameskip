package com.quilodran.frameskip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @GetMapping("")
    public String getQuote() {
        return "Lorem Ipsum";
    }
}
