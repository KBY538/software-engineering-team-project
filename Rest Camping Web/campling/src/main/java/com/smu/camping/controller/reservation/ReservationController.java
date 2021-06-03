package com.smu.camping.controller.reservation;

import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;

/*	public ApiResponse Reservation(ReservationDto reservationDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

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
	
	public int getTotalCost(ReservationDto reservationDto){
		
	}*/
}
