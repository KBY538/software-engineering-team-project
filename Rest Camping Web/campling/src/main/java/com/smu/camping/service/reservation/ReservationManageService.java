package com.smu.camping.service.reservation;

import com.smu.camping.mapper.reservation.ReservationManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationManageService {
	@Autowired
	ReservationManageMapper reservationManageMapper;
	
/*	public int approveReservation(int reservationId){

	}

	public int rejectReservation(int reservationId){

	}*/
}
