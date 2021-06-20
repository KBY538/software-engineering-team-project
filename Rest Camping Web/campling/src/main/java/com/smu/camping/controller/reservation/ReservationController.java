package com.smu.camping.controller.reservation;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;

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

	public List<ReservationDto> getReservationByUsername(@AuthenticationPrincipal CustomUserDetails userDetails){
		String username = userDetails.getUsername();
		return reservationService.getReservationByUsername(username);
	}

	@PutMapping("/reservation")
	public ApiResponse updateReservation(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody ReservationDto reservationDto){
		int result = reservationService.updateReservation(reservationDto);
		return (result > 0) ? new ApiResponse(false, "") : new ApiResponse(true, "예약 수정에 실패했습니다.");
	}

	@DeleteMapping("/reservation")
	public ApiResponse cancelReservation(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestParam("reservationId") int reservationId){
		int result = reservationService.deleteReservation(reservationId);
		return (result > 0) ? new ApiResponse(false, "") : new ApiResponse(true, "예약 취소에 실패했습니다.");
	}

	@GetMapping("/reservation/{reservationId}")
	public ReservationDto getReservationByReservationId(@AuthenticationPrincipal CustomUserDetails userDetails, @PathVariable("reservationId") int reservationId){
		return reservationService.getReservationByReservationId(reservationId);
	}

/*
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	*/
}
