package com.example.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/admin")
public class WebController {
    @RequestMapping
    public String index(Model model)
    {
        return "admin/home";
    }
}

