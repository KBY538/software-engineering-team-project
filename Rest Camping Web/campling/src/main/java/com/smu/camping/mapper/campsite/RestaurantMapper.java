package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.campsite.RestaurantDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMapper {
	public int createRestaurants(List<RestaurantDto> restaurantDtos);
	public int updateRestaurants(List<RestaurantDto> restaurantDtos);
	public int deleteRestaurant(int restaurantId);
	public RestaurantDto getRestaurant(int restaurantId);
	public List<RestaurantDto> getRestaurantByCampsiteId(int restaurantId);
}
