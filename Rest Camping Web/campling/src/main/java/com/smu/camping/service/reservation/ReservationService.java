package com.smu.camping.service.reservation;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.MealKitDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.reservation.MealKitOrderDto;
import com.smu.camping.dto.reservation.ReservationDto;
import com.smu.camping.mapper.reservation.ReservationMapper;
import com.smu.camping.service.campsite.CampsiteInfoService;
import com.smu.camping.service.campsite.MealKitService;
import com.smu.camping.service.campsite.RoomService;
import com.smu.camping.util.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private CampsiteInfoService campsiteService;

	@Autowired
	private MealKitService mealKitService;

	@Autowired
	private RoomService roomService;

	@Transactional(readOnly = true)
	public int getTotalCost(ReservationDto reservationDto){
		int campsiteId = reservationDto.getCampsiteDto().getId();

		CampsiteDto campsiteDto = campsiteService.getCampsiteInfoByCampsiteId(campsiteId);
		RoomDto roomDto = reservationDto.getRoomDto();

		roomDto = roomService.getRoomByRoomId(roomDto.getId());
		int pricePerExcessCar = campsiteDto.getPricePerExcessCar();
		int pricePerExcessPerson = campsiteDto.getPricePerExcessPerson();
		int baseHeadCnt = roomDto.getBaseHeadCnt();
		int baseNumCars = roomDto.getBaseNumCars();

		Date checkInDate = reservationDto.getCheckInDate();
		Date checkOutDate = reservationDto.getCheckOutDate();
		int dateDiff = CalendarUtil.calculateDateDiff(checkOutDate, checkInDate);

		int totalPrice = roomDto.getPrice() * (dateDiff + 1);

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
		int createCnt = reservationMapper.createReservation(reservationDto);
		int reservationId = reservationDto.getId();
		List<MealKitOrderDto> mealKitOrderDtos =  reservationDto.getMealKitOrders();

		mealKitService.createMealKitOrder(mealKitOrderDtos, reservationId);

		return createCnt;
	}

	public int deleteReservation(int reservationId){
		return reservationMapper.deleteReservation(reservationId);
	}

	public int updateReservation(ReservationDto reservationDto){
		return reservationMapper.updateReservation(reservationDto);
	}

	@Transactional(readOnly = true)
	public ReservationDto getReservationByReservationId(int reservationId){
		ReservationDto reservationDto = reservationMapper.getReservationByReservationId(reservationId);

		int campsiteId = reservationDto.getCampsiteDto().getId();
		int roomId = reservationDto.getRoomDto().getId();

		CampsiteDto campsiteDto = campsiteService.getCampsiteInfoByCampsiteId(campsiteId);
		RoomDto roomDto = roomService.getRoomByRoomId(roomId);
		List<MealKitOrderDto> mealKitOrderDtos = mealKitService.getMealkitOrderByReservationId(reservationId);

		for(MealKitOrderDto mealKitOrderDto : mealKitOrderDtos){
			int mealKitId = mealKitOrderDto.getMealKit().getId();
			mealKitOrderDto.setMealKit(mealKitService.getMealKit(mealKitId));
		}

		reservationDto.setRoomDto(roomDto);
		reservationDto.setCampsiteDto(campsiteDto);
		reservationDto.setMealKitOrders(mealKitOrderDtos);

		return reservationDto;
	}

	@Transactional(readOnly = true)
	public List<ReservationDto> getReservationByUsername(String username){
		List<ReservationDto> camperReservationInfos = reservationMapper.getReservationByUsername(username);

		for (ReservationDto reservationDto : camperReservationInfos){
			int roomId = reservationDto.getRoomDto().getId();
			int campsiteId = reservationDto.getCampsiteDto().getId();
			reservationDto.setCampsiteDto(campsiteService.getCampsiteInfoByCampsiteId(campsiteId));
			reservationDto.setRoomDto(roomService.getRoomByRoomId(roomId));
		}

		return camperReservationInfos;
	}

	@Transactional(readOnly = true)
	public List<ReservationDto> getReservationByOwner(String owner){
		CampsiteDto campsiteDto = campsiteService.getCampsiteInfoByUserName(owner);
		if(campsiteDto != null){
			int campsiteId = campsiteDto.getId();
			List<ReservationDto> reservationDtos = getReservationByCampsiteId(campsiteId);

			for(ReservationDto reservationDto : reservationDtos){
				int roomId = reservationDto.getRoomDto().getId();
				reservationDto.setRoomDto(roomService.getRoomByRoomId(roomId));
			}

			return reservationDtos;
		}
		return null;
	}

	@Transactional(readOnly = true)
	public List<ReservationDto> getReservationByCampsiteId(int campsiteId){
		return reservationMapper.getReservationByCampsiteId(campsiteId);
	}

/*
	@Transactional(readOnly = true)
	public boolean reservationIsAvailable(ReservationDto reservationDto){
		
	}*/
}
