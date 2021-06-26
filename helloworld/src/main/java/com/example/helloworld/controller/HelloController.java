package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format(template, name);
    }

}
