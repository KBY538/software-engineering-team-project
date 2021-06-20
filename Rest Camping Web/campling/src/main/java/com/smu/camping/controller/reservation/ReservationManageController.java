package com.smu.camping.controller.reservation;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.service.reservation.ReservationManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationManageController {
	@Autowired
	private ReservationManageService reservationManageService;

	@Autowired
	private RoomMapper roomMapper;

	@PutMapping("/reservation/approve")
	public ApiResponse approveReservation(@RequestParam("reservationId") int reservationId){
		int result = reservationManageService.approveReservation(reservationId);
		return (result > 0)? new ApiResponse(false, "") : new ApiResponse(true, "예약 승인에 실패하였습니다.");
	}

	@PutMapping("/reservation/reject")
	public ApiResponse rejectReservation(@RequestParam("reservationId") int reservationId){
		int result = reservationManageService.rejectReservation(reservationId);
		return (result > 0)? new ApiResponse(false, "") : new ApiResponse(true, "예약 거부에 실패하였습니다.");
	}
}
