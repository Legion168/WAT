package com.org.watweb.controllers;

import com.org.watdata.model.Credentials;
import com.org.watweb.services.CredentialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final CredentialService credentialService;

    public LoginController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @GetMapping({"", "/", "/login", "/login.html"})
    public String toLogin(Model model) {
        model.addAttribute("credentials", credentialService.getCredential());

        return "login";
    }

    @PostMapping("/login")
    public String checkCredentials(@ModelAttribute("credentials") Credentials credentials) {

        return credentialService.verifyCredential(credentials) ? "dashboard" : "login";
    }
}
