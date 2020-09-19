package com.org.watweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"", "/", "/login", "/login.html"})
    public String toLogin() {
        return "login";
    }
}
