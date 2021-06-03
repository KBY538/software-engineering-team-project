package com.smu.camping.service.campsite;

import com.smu.camping.mapper.campsite.RestaurantMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.RestaurantImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;

import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService{
	@Autowired
	RestaurantMapper restaurantMapper;
	
	@Autowired
	RestaurantImageInfoMapper restaurantImageInfoMapper;
	
	@Autowired
	FileInfoMapper fileInfoMapper;
	
	@Autowired
	FileUtil fileUtil;
	
/*	@Transactional(readOnly = false)
	public int createRestaurants(List<RestaurantDto> restaurantDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int updateRestaurants(List<RestaurantDto> restaurantDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteRestaurant(int restaurantId){
		
	}
	
	public RestaurantDto getRestaurant(int restaurantId){
		
	}*/
}
