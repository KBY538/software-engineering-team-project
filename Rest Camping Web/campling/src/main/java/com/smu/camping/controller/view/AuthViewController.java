package com.smu.camping.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthViewController {
    @GetMapping("/login")
    public String loginPage() {
        return "auth/Login";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "auth/SignUp";
    }
}
