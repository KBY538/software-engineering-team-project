package com.smu.camping.controller.reservation;

import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.service.reservation.ReservationManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationManageController {
	@Autowired
	private ReservationManageService reservationManageService;

	@Autowired
	private RoomMapper roomMapper;
	
/*	public ApiResponse approveReservation(int reservationId){
		
	}
	
	public ApiResponse rejectReservation(int reservationId){
		
	}*/
}
