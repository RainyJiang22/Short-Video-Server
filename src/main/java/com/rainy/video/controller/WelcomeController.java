package com.rainy.video.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jacky
 * @date 2024/12/4
 **/

@RestController
@RequestMapping(value = "/")
public class WelcomeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome To Short Video Server";
    }

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }
}
