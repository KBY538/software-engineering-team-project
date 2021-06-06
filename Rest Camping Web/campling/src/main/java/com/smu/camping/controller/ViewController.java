package com.smu.camping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/main")
    public String mainPage() {
        return "Main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/Login";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "auth/SignUp";
    }

    @GetMapping("/campsite")
    public String CampsiteSearchPage() {
        return "/campsite/Search";
    }

    @GetMapping("/community")
    public String communityPage() {
        return "Community";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "MyPage";
    }

    @GetMapping("/notice")
    public String noticePage() {
        return "Notice";
    }
}
