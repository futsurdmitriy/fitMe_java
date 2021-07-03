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

package com.fuda.fitMe.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/hello")
    String getHello() {
        return "<h1>Hello from "
                + this.getClass().getCanonicalName()
                + "</h1>";
    }
}
