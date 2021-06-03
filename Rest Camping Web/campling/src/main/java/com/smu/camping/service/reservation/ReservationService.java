package com.smu.camping.service.reservation;

import com.smu.camping.mapper.campsite.CampsiteInfoMapper;
import com.smu.camping.mapper.campsite.MealKitMapper;
import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.reservation.ReservationMapper;
import com.smu.camping.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

/*	@Transactional(readOnly = false)
	public int createReservation(ReservationDto reservationDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteReservation(int reservationId){
		
	}

	@Transactional(readOnly = false)
	public int updateReservation(ReservationDto reservationDto){
		
	}
	
	public ReservationDto getReservationByReservationId(int reservationId){
		
	}
	
	public List<ReservationDto> getReservationByUsername(String username){
		
	}
	
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId){
		
	}

	public int getTotalCost(ReservationDto reservationDto){
		
	}
	
	public boolean reservationIsAvailable(ReservationDto reservationDto){
		
	}*/
}
