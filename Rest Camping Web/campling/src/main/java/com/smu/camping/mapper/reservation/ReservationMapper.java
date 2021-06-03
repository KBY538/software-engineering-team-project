package com.smu.camping.mapper.reservation;

import com.smu.camping.dto.reservation.ReservationDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationMapper {
	public int createReservation(ReservationDto reservationDto);
	public int deleteReservation(int reservationId);
	public int updateReservation(ReservationDto reservationDto);
	public ReservationDto getReservationByReservationId(int reservationId);
	public List<ReservationDto> getReservationByUsername(String username);
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId);
}
