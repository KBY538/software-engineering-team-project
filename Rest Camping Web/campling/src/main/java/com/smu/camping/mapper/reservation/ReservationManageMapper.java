package com.smu.camping.mapper.reservation;

import org.springframework.stereotype.Repository;

@Repository
public interface ReservationManageMapper {
	public int approveReservation(int reservationId);
	public int rejectReservation(int reservationId);
}
