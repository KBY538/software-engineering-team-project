package com.smu.camping;

import com.smu.camping.dto.user.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ViewController {
    @ModelAttribute("userInfo")
    public Map<String, String> userInfoModelAttribute(@AuthenticationPrincipal CustomUserDetails userDetails){
        Map<String, String> infoMap = new HashMap<String, String>();

        if (userDetails != null){
            String username = userDetails.getUsername();
            infoMap.put("username", username);
        }
        return infoMap;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/Login";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "auth/SignUp";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "Main";
    }

    @GetMapping("/campsite")
    public String CampsiteSearchPage() {
        return "/campsite/Search";
    }

    @GetMapping("/community")
    public String communityPage() {
        return "Community";
    }

    @GetMapping("/notice")
    public String noticePage() {
        return "Notice";
    }

    @GetMapping(value = {"/mypage", "/mypage/{menu}"})
    public String mypage(@AuthenticationPrincipal CustomUserDetails userDetails, ModelMap modelMap, @PathVariable(name = "menu", required = false) String menu){
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        List<String> strAuthorities = new ArrayList<>();

        for(GrantedAuthority authority : authorities){
            strAuthorities.add(authority.getAuthority());
        }

        modelMap.addAttribute("user_role", strAuthorities);
        modelMap.addAttribute("menu", menu);

        return "myPage/MyPage";
    }
}
