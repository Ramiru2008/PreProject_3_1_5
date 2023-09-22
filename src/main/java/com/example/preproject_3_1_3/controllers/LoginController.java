package com.example.preproject_3_1_3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }
    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal) {
        return "secured part of web service: " + principal.getName();
    }
}
