package com.example.project;

import com.example.project.properties.ExampleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties(ExampleProperties.class)
public class Example {

    private final ExampleProperties exampleProperties;

    @Autowired
    public Example(ExampleProperties exampleProperties) {
        this.exampleProperties = exampleProperties;
    }

    @RequestMapping("/")
    String home()
    {
        String firstName = this.exampleProperties.getFirstName();
        String lastName = this.exampleProperties.getLastName();
        return "Hello " + firstName + " " + lastName + ", nice to meet you!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}