package com.smu.camping.controller.view;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class MyPageViewController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CampsiteInfoService campsiteInfoService;

    @ModelAttribute("userInfo")
    public Map<String, String> userInfoModelAttribute(@AuthenticationPrincipal CustomUserDetails userDetails){
        Map<String, String> infoMap = new HashMap<>();

        if (userDetails != null){
            String username = userDetails.getUsername();
            infoMap.put("username", username);
        }
        return infoMap;
    }

    @GetMapping(value = {"/mypage", "/mypage/{menu}"})
    public String mypage(@AuthenticationPrincipal CustomUserDetails userDetails, ModelMap modelMap, @PathVariable(name = "menu", required = false) String menu){
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        String username = userDetails.getUsername();

        List<ReservationDto> ownerReservationInfos = reservationService.getReservationByOwner(username);
        List<ReservationDto> camperReservationInfos = reservationService.getReservationByUsername(username);
        List<CampsiteDto> campsiteDtoList = campsiteInfoService.getAllCampsiteInfo();

        List<String> strAuthorities = new ArrayList<>();

        for(GrantedAuthority authority : authorities){
            strAuthorities.add(authority.getAuthority());
        }

        modelMap.addAttribute("campsiteDtoList", campsiteDtoList);
        modelMap.addAttribute("ownerReservationInfos", ownerReservationInfos);
        modelMap.addAttribute("camperReservationInfos", camperReservationInfos);
        modelMap.addAttribute("user_role", strAuthorities);
        modelMap.addAttribute("menu", menu);

        return "myPage/MyPage";
    }
}
