package com.kevincode.controller;

import com.kevincode.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User: kevin.xie<br/>
 * Date: 13/04/2020<br/>
 * Time: 18:36<br/>
 */
@Log4j2
public class RequestController {


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void process2(@RequestBody User user) {
        log.info("User: {}", user);
    }

}
