package com.spartanwrath.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Webcontroller {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/AboutUs")
    public String AboutUs(){
        return "aboutUs";
    }

}
