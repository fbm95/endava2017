package com.endava.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/test1")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}