package com.arty.togetapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllers {

    @GetMapping
    public String index (Model model){
        model.addAttribute("data", "Hello");
         return "index";
    }

}
