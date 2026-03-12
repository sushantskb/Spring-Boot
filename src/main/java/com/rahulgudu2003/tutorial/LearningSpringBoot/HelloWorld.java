package com.rahulgudu2003.tutorial.LearningSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "My first spring App";
    }
}
