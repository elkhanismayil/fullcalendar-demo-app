package com.example.fullcalendardemoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/")
    public String goHomePage(){
        return "index";
    }
}
