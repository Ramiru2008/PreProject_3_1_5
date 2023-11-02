package com.example.preproject_3_1_5.controllers;

import com.example.preproject_3_1_5.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser(Principal principal, ModelMap model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "user";
    }
    @GetMapping("/adminuser")
    public String getAdminUser(Principal principal, ModelMap model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "adminuser";
    }
}
