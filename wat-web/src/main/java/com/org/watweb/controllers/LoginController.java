package com.org.watweb.controllers;

import com.org.watweb.model.CredentialLogin;
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
        model.addAttribute("triedToLog", false);

        return "login";
    }

    @PostMapping("/login")
    public String checkCredentials(@ModelAttribute("credentials") CredentialLogin credentials, Model model) {
        if (credentialService.verifyCredential(credentials)) {
            return "dashboard";
        } else {
            model.addAttribute("triedToLog", true);
        }

        return "login";
    }
}
