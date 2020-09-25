package com.org.watweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping({"/dashboard", "/dashboard.html"})
    public String toDashboard() {

        return "dashboard";
    }
}


