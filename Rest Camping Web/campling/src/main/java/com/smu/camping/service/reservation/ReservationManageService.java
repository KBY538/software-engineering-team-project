package com.smu.camping.service.reservation;

import com.smu.camping.mapper.reservation.ReservationManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationManageService {
	@Autowired
	private ReservationManageMapper reservationManageMapper;

	public int approveReservation(int reservationId){
		return reservationManageMapper.approveReservation(reservationId);
	}

	public int rejectReservation(int reservationId){
		return reservationManageMapper.rejectReservation(reservationId);
	}
}
