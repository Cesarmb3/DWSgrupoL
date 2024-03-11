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
    @GetMapping("/error")
    public String error() {
        return "error";
    }

<<<<<<< Updated upstream
    @GetMapping("/Market")
    public String market() { return "market";}

    @GetMapping("/login")
    public String login() { return "login";}

=======
>>>>>>> Stashed changes
}
