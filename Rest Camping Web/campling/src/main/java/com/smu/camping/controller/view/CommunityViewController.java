package com.smu.camping.controller.view;

import com.smu.camping.dto.user.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CommunityViewController {
    @ModelAttribute("userInfo")
    public Map<String, String> userInfoModelAttribute(@AuthenticationPrincipal CustomUserDetails userDetails){
        Map<String, String> infoMap = new HashMap<>();

        if (userDetails != null){
            String username = userDetails.getUsername();
            infoMap.put("username", username);
        }
        return infoMap;
    }

    @GetMapping("/community")
    public String communityPage() {
        return "Community";
    }
}
