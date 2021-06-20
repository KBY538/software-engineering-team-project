package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.ImageInfoDto;
import com.smu.camping.dto.campsite.RestaurantDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.RestaurantMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.RestaurantImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;

import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class RestaurantService{
	@Autowired
	private RestaurantMapper restaurantMapper;
	
	@Autowired
	private RestaurantImageInfoMapper restaurantImageInfoMapper;
	
	@Autowired
	private FileInfoMapper fileInfoMapper;
	
	@Autowired
	private FileUtil fileUtil;

	@Transactional(readOnly = true)
	public List<RestaurantDto> getRestaurantByCampsiteId(int campsiteId){

		List<RestaurantDto> restaurantDtos = restaurantMapper.getRestaurantByCampsiteId(campsiteId);
		for (RestaurantDto restaurantDto : restaurantDtos){
			int restaurantId = restaurantDto.getId();
			ImageInfoDto imageInfoDto = restaurantImageInfoMapper.getImageInfoById(restaurantId);
			FileInfoDto fileInfoDto = fileInfoMapper.getFileInfo(imageInfoDto.getImageId());
			restaurantDto.setImage(fileInfoDto);
		}

		return restaurantDtos;
	}

	public int createRestaurants(List<RestaurantDto> restaurantDtos, int campsiteId, String owner){
		int createCnt = 0;

		for (RestaurantDto restaurantDto : restaurantDtos){
			restaurantDto.setCampsiteId(campsiteId);
			createCnt += restaurantMapper.createRestaurant(restaurantDto);
			int roomId = restaurantDto.getId();
			FileInfoDto fileInfoDto = restaurantDto.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(fileInfoDto);
			restaurantImageInfoMapper.createImageInfo(new ImageInfoDto(roomId, fileInfoDto.getId()));
		}

		return createCnt;
	}
/*
	public int updateRestaurants(List<RestaurantDto> restaurantDtos, List<MultipartFile> multipartFiles){
		
	}

	public int deleteRestaurant(int restaurantId){
		
	}

	@Transactional(readOnly = true)
	public RestaurantDto getRestaurant(int restaurantId){
		
	}*/
}
