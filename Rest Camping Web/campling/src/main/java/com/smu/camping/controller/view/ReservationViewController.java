package com.smu.camping.controller.view;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.campsite.RoomService;
import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ReservationViewController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private CampsiteInfoService campsiteInfoService;

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

        return "reservation/Confirm";
    }
}
