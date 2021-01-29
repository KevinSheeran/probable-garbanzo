package com.kevincode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: kevin.xie<br/>
 * Date: 22/06/2020<br/>
 * Time: 13:43<br/>
 */
@RequestMapping("/api")
public class MappingController {


    @RequestMapping("/getFirstChange")
    public String getFirstChange() {
        return getFirstSunChange();
    }

    @GetMapping("/getSun")
    public String getFirstSunChange() {
        return "This is my First sun change";
    }

}
