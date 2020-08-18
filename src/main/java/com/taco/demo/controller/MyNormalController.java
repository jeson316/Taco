package com.taco.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyNormalController {

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }
}
