package com.smu.camping.controller.view;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.campsite.MealKitService;
import com.smu.camping.service.campsite.RoomService;
import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.*;

@Controller
public class ViewController {
    @Autowired
    private CampsiteInfoService campsiteInfoService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @ModelAttribute("userInfo")
    public Map<String, String> userInfoModelAttribute(@AuthenticationPrincipal CustomUserDetails userDetails){
        Map<String, String> infoMap = new HashMap<>();

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

    @GetMapping("/campsite/{campsiteId}")
    public String campsitePage(ModelMap modelMap, @PathVariable("campsiteId") int campsiteId){
        CampsiteDto campsiteDto = campsiteInfoService.getCampsiteInfoByCampsiteId(campsiteId);

        modelMap.addAttribute("campsiteDto", campsiteDto);
        return "/campsite/CampsiteInfo";
    }

    @GetMapping("/reservation/{campsiteId}/{roomId}")
    public String reservationPage(ModelMap modelMap,
                                  @PathVariable("campsiteId") int campsiteId, @PathVariable("roomId") int roomId,
                                  @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){

        CampsiteDto campsiteDto = campsiteInfoService.getCampsiteInfoByCampsiteId(campsiteId);
        RoomDto roomDto = roomService.getRoomByRoomId(roomId);

        modelMap.addAttribute("startDate", startDate);
        modelMap.addAttribute("endDate", endDate);
        modelMap.addAttribute("campsiteDto", campsiteDto);
        modelMap.addAttribute("roomDto", roomDto);

        return "reservation/Reservation";
    }

    @GetMapping("/reservation/confirm/{reservationId}")
    public String reservationConfirmPage(ModelMap modelMap, @PathVariable("reservationId") int reservationId){
        ReservationDto reservationDto = reservationService.getReservationByReservationId(reservationId);
        modelMap.addAttribute("reservationDto", reservationDto);

        System.out.println(reservationDto.getMealKitOrders());
        return "reservation/Confirm";
    }
}
