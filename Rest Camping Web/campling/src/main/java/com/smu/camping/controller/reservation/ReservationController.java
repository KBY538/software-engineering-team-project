package com.smu.camping.controller.reservation;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.dto.user.UserDto;
import com.smu.camping.service.reservation.ReservationService;
import com.smu.camping.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;

	@Autowired
	private UserService userService;

	@PostMapping("/reservation/cost")
	public int getTotalCost(@RequestBody ReservationDto reservationDto){
		return reservationService.getTotalCost(reservationDto);
	}

	@PostMapping("/reservation")
	public ApiResponse Reservation(@RequestBody  ReservationDto reservationDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		Map<String, Object> resultMap = new HashMap<>();

		String username = userDetails.getUsername();
		reservationDto.setUsername(username);

		int totalCost = reservationService.getTotalCost(reservationDto);
		reservationDto.setTotalPrice(totalCost);

		int createCnt = reservationService.createReservation(reservationDto);
		resultMap.put("id", reservationDto.getId());

		return (createCnt > 0) ? new ApiResponse(resultMap) : new ApiResponse(true, "예약에 실패하였습니다.");
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
