package com.smu.camping.controller.view;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CampsiteViewController {
    @ModelAttribute("userInfo")
    public Map<String, String> userInfoModelAttribute(@AuthenticationPrincipal CustomUserDetails userDetails){
        Map<String, String> infoMap = new HashMap<>();

        if (userDetails != null){
            String username = userDetails.getUsername();
            infoMap.put("username", username);
        }
        return infoMap;
    }

    @Autowired
    private CampsiteInfoService campsiteInfoService;

    @GetMapping("/campsite/{campsiteId}")
    public String campsitePage(ModelMap modelMap, @PathVariable("campsiteId") int campsiteId){
        CampsiteDto campsiteDto = campsiteInfoService.getCampsiteInfoByCampsiteId(campsiteId);

        modelMap.addAttribute("campsiteDto", campsiteDto);
        return "/campsite/CampsiteInfo";
    }

    @GetMapping("/campsite")
    public String CampsiteSearchPage() {
        return "/campsite/Search";
    }
}
