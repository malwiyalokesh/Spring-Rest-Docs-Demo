package com.sample.restdocsdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.restdocsdemo.model.Greeting;
import com.sample.restdocsdemo.model.User;

@RestController
public class GreetingController {

    @PostMapping("/greeting")
    public Greeting hello_greeting(@RequestBody final User user) {

        return new Greeting(buildGreetStr(user));

    }

    private String buildGreetStr(User user) {
        return "Hello " + user.getName() + " with email " + user.getEmail();
    }

}
