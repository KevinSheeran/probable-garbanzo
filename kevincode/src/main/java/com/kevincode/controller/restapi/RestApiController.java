package com.kevincode.controller.restapi;

import org.springframework.web.bind.annotation.*;

/**
 * User: kevin.xie<br/>
 * Date: 30/09/2020<br/>
 * Time: 14:08<br/>
 */
@RestController
public class RestApiController {

    @DeleteMapping("/delete")
    public String delete() {
        return "";
    }

    @RequestMapping(method = RequestMethod.OPTIONS, value = "/options")
    public String options() {
        return "";
    }

    @PutMapping("/putAgainst")
    public String put() {
        return "";
    }

    @RequestMapping(method = RequestMethod.TRACE, value = "/")
    public String trace() {
        return "'";
    }

}
