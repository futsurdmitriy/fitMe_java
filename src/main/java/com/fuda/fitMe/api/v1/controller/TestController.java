/*

 *  Class name :  TestController
 *  @author Dmitriy Futsur (https://github.com/futsurdmitriy)
 *  @since 03-Jul-2021
 *  @version 1.0.0
 *  Copyright (c) Dmitriy Futsur
 *  
 *  Description:
 *     This is test controller for MyFit application.
 */

package com.fuda.fitMe.api.v1.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RequestMapping("api/v1/test")
@RestController
public class TestController {

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    String getHello() {
        return "{\"response\": \"Hello from "
                + this.getClass().getCanonicalName()
                + "\"}";
    }

}
