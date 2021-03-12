package com.mabshura.FirstSpringBoot.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MyRestController {
    @Value("${person.abrha}")
    private String name;

    @GetMapping("/")
    public String hello(){
        return "Hello Spring Boot from "+ name;
//        return "Hello Spring Boot from "+ LocalDate.now();
    }

    @GetMapping("/test")
    public String getTest(){
        return "Testing in effect checing...";
    }

    @GetMapping("/test2")
    public String getTest2(){
        return "Testing in effect checing...";
    }
}
