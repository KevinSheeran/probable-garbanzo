package com.kevincode.controller;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: kevin.xie<br/>
 * Date: 13/04/2020<br/>
 * Time: 10:31<br/>
 */
@Log4j2
@RestController
@RequestMapping("/api/")
public class UnirestController {


   /* @RequestMapping("/testJ")
    public String testJ(String path) {
        Unirest.post("")
                .
                .header("Content-Type","application/json");
        return "";
    }*/

    @PostMapping("/postJson")
    public HttpResponse<JsonNode> post() {
        HttpResponse<JsonNode> response = Unirest.post("http://httpbin.org/post")
                .queryString("apiKey", "123")
                .field("parameter", "value")
                .field("firstname", "Gary")
                .asJson();
        log.debug("postJson: \n{}", response);
        return response;
    }

   /* @RequestMapping("/testField")
    public String testField() {
        String response = Unirest.post("http://httpbin.org/post")
                .body()
                .asString();
        return response;
    }*/


    public String test1() {
       Unirest.config();
        log.debug("http://homestar.com");
        return "";
    }

}
