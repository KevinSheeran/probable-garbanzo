package com.kevincode.controller.jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevin.xie<br/>
 * Date: 29/09/2020<br/>
 * Time: 17:16<br/>
 */
@RestController
public class LoginController {


    @GetMapping("/api/hello")
    public String hello() {
        return "Hello Springboot integrate JWT!";
    }

    @PostMapping("/api/login")
    public String login() {
        return "Welcome to login";
    }


    @GetMapping("/home")
    public String home() {
        return "Welcome, KevinCode";
    }


}
