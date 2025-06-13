package com.testjune.june.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/ping")
    public String ping() {
        return "App is running!";
    }
}
