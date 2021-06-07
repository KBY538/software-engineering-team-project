package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.campsite.MealKitDto;
import com.smu.camping.dto.reservation.MealKitOrderDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealKitMapper {
	public int createMealkit(MealKitDto MealKitDto);
	public int updateMealkits(List<MealKitDto> MealKitDtos);
	public int deleteMealkit(int mealKitId);
	public List<MealKitDto> getMealKitByCampsiteId(int campsiteId);
	public MealKitDto getMealKit(int mealKitId);
	public List<MealKitOrderDto> getMealKitOrderByReservationId(int reservationId);
}
