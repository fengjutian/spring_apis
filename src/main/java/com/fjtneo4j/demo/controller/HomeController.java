package com.fjtneo4j.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the home page!";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf() {
        return "thymeleaf"; // This returns the template named index.html
    }
}
