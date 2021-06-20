package com.smu.camping.service.reservation;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.MealKitDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.reservation.MealKitOrderDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.mapper.campsite.CampsiteInfoMapper;
import com.smu.camping.mapper.campsite.MealKitMapper;
import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.reservation.ReservationMapper;
import com.smu.camping.mapper.user.UserMapper;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.campsite.MealKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
	@Autowired
	private CampsiteInfoService campsiteService;

	@Autowired
	private MealKitService mealKitService;

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private MealKitMapper mealkitMapper;
	
	@Autowired
	private CampsiteInfoMapper campsiteInfoMapper;
	
	@Autowired
	private RoomMapper roomMapper;

	@Transactional(readOnly = true)
	public int getTotalCost(ReservationDto reservationDto){
		int campsiteId = reservationDto.getCampsiteDto().getId();

		CampsiteDto campsiteDto = campsiteService.getCampsiteInfoByCampsiteId(campsiteId);
		int pricePerExcessCar = campsiteDto.getPricePerExcessCar();
		int pricePerExcessPerson = campsiteDto.getPricePerExcessPerson();
		RoomDto roomDto = reservationDto.getRoomDto();
		int baseHeadCnt = roomDto.getBaseHeadCnt();
		int baseNumCars = roomDto.getBaseNumCars();

		int totalPrice = 0;

		int reservationHeadCnt = reservationDto.getReservationHeadCnt();
		totalPrice += (reservationHeadCnt > baseHeadCnt) ? (reservationHeadCnt - baseHeadCnt) * pricePerExcessPerson : 0;
		int reservationNumCars = reservationDto.getReservationNumCars();
		totalPrice += (reservationNumCars > baseNumCars) ? (reservationNumCars - baseNumCars) * pricePerExcessCar : 0;

		List<MealKitOrderDto> mealKitOrderDtos = reservationDto.getMealKitOrders();

		for(MealKitOrderDto mealKitOrderDto : mealKitOrderDtos){
			int mealKitId = mealKitOrderDto.getMealKit().getId();
			int mealKitCnt = mealKitOrderDto.getCnt();

			MealKitDto mealKitDto = mealKitService.getMealKit(mealKitId);
			totalPrice += mealKitDto.getPrice() * mealKitCnt;
		}

		return totalPrice;
	}

	public int createReservation(ReservationDto reservationDto){
		return reservationMapper.createReservation(reservationDto);
	}

/*

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
	public boolean reservationIsAvailable(ReservationDto reservationDto){
		
	}*/
}
