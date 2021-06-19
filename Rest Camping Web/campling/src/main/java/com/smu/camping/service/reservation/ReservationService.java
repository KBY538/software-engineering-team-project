package com.smu.camping.service.reservation;

import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.mapper.campsite.CampsiteInfoMapper;
import com.smu.camping.mapper.campsite.MealKitMapper;
import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.reservation.ReservationMapper;
import com.smu.camping.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
	@Autowired
	ReservationMapper reservationMapper;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	MealKitMapper mealkitMapper;
	
	@Autowired
	CampsiteInfoMapper campsiteInfoMapper;
	
	@Autowired
	RoomMapper roomMapper;

/*	public int createReservation(ReservationDto reservationDto){
		
	}

	public int deleteReservation(int reservationId){
		
	}

	public int updateReservation(ReservationDto reservationDto){
		
	}

	@Transactional(readOnly = true)
	public ReservationDto getReservationByReservationId(int reservationId){
		
	}

	@Transactional(readOnly = true)
	public List<ReservationDto> getReservationByUsername(String username){
		
	}

	@Transactional(readOnly = true)
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId){
		
	}

	@Transactional(readOnly = true)
	public int getTotalCost(ReservationDto reservationDto){
		
	}

	@Transactional(readOnly = true)
	public boolean reservationIsAvailable(ReservationDto reservationDto){
		
	}*/
}
