package com.vini.duck.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DuckController {
    @GetMapping ("/")
    public String home () {
        return "/home";
    }
}
