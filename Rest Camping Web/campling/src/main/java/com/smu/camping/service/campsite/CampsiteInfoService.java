package com.smu.camping.service.campsite;

import com.smu.camping.mapper.campsite.*;
import com.smu.camping.mapper.campsite.imageInfoMapper.CampsiteImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampsiteInfoService{
	@Autowired
	CampsiteInfoMapper campsiteInfoMapper;

	@Autowired
	RestaurantMapper restaurantMapper;
	
	@Autowired
	MealKitMapper mealKitMapper;
	
	@Autowired
	FileInfoMapper fileInfoMapper;
	
	@Autowired
	FileUtil fileUtil;
	
	@Autowired
	RoomMapper roomMapper;
	
	@Autowired
	TouristMapper touristMapper;
	
	@Autowired
	CampsiteImageInfoMapper campsiteImageInfoMapper;
	
	@Autowired
	CampsiteReviewMapper campsiteReviewMapper;

/*	@Transactional(readOnly = false)
	public int createCampsiteInfo(CampsiteDto campsiteDto){
		
	}

	@Transactional(readOnly = false)
	public int updateCampsiteInfo(CampsiteDto campsiteDto){
		
	}
	
	public List<CampsiteDto> getAllCampsiteInfo(){
		
	}
	
	public CampsiteDto getCampsiteInfoByUserName(String owner){
		
	}
	
	public CampsiteDto getCampsiteInfoByCampsiteId(int CampsiteId){
		
	}
	
	public List<CampsiteDto> getCampsiteOrderByReviewNum(){
		
	}
	
	public List<CampsiteDto> getCampsiteInfoByFilter(SearchFilterDto searchFilterDto){
		
	}*/
}
