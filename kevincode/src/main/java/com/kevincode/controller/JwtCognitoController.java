package com.kevincode.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevin.xie<br/>
 * Date: 28/09/2020<br/>
 * Time: 15:55<br/>
 */
@Log4j2
@RestController
public class JwtCognitoController {

    @GetMapping("/hello/api")
    public String helloCognito() {
       log.debug("Jwt Cognito is coming...");
        return "Hello Authentication Request";
    }

}
