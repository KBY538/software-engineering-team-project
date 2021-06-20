package com.smu.camping.controller.campsite;

import com.smu.camping.service.campsite.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
/*	public ApiResponse createRestaurants(List<RestaurantDto> restaurantDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse updateRestaurants(List<RestaurantDto> restaurantDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse deleteRestaurant(int restaurantId){
		
	}
	
	public RestaurantDto getRestaurant(int restaurantId){
		
	}*/
}
