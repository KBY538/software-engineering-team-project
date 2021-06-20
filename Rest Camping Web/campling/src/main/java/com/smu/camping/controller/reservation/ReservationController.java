package com.smu.camping.controller.reservation;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.MealKitDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.reservation.MealKitOrderDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.campsite.MealKitService;
import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
	@PostMapping("/reservation/cost")
	public int getTotalCost(@RequestBody ReservationDto reservationDto){
		return getTotalCost(reservationDto);
	}

	@PostMapping("/reservation")
	public ApiResponse Reservation(ReservationDto reservationDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		int totalCost = getTotalCost(reservationDto);
		reservationDto.setTotalPrice(totalCost);

		return null;
	}

/*
	public ApiResponse cancelReservation(int reservationId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse updateReservation(ReservationDto reservationDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public ReservationDto getReservationByReservationId(int reservationId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<ReservationDto> getReservationByUsername(@AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	*/
}
