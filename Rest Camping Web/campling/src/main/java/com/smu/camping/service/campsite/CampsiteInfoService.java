package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.*;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.*;
import com.smu.camping.mapper.campsite.imageInfoMapper.*;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
	FacilityMapper facilityMapper;

	@Autowired
	OperatingMapper operatingMapper;

	@Autowired
	CampsiteReviewMapper campsiteReviewMapper;

	@Autowired
	MealKitImageInfoMapper mealKitImageInfoMapper;

	@Autowired
	RestaurantImageInfoMapper restaurantImageInfoMapper;

	@Autowired
	RoomImageInfoMapper roomImageInfoMapper;

	@Autowired
	TouristImageInfoMapper touristImageInfoMapper;

	public List<CampsiteDto> getCampsiteInfoByFilter(SearchFilterDto searchFilterDto){
		return campsiteInfoMapper.getCampsiteInfoByFilter(searchFilterDto);
	}

	@Transactional(readOnly = false)
	public int createCampsiteInfo(CampsiteDto campsiteDto){

		int createCnt = campsiteInfoMapper.createCampsiteInfo(campsiteDto);
		int campsiteId = campsiteDto.getId();
		String owner = campsiteDto.getOwner();

		facilityMapper.createCampsiteFacility(campsiteId, campsiteDto.getFacilities());
		operatingMapper.createCampsiteOperating(campsiteId, campsiteDto.getOperatingTypes());

		List<RoomDto> rooms = campsiteDto.getRooms();
		for (RoomDto room : rooms){
			room.setCampsiteId(campsiteId);
			roomMapper.createRoom(room);
			int roomId = room.getId();
			FileInfoDto fileInfoDto = room.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(room.getImage());
			roomImageInfoMapper.createImageInfo(new ImageInfoDto(roomId, fileInfoDto.getId()));
		}

		List<RestaurantDto> restaurantInfos = campsiteDto.getRestaurantInfos();
		for (RestaurantDto restaurant : restaurantInfos){
			restaurant.setCampsiteId(campsiteId);
			restaurantMapper.createRestaurant(restaurant);
			int restaurantId = restaurant.getId();
			FileInfoDto fileInfoDto = restaurant.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(restaurant.getImage());
			restaurantImageInfoMapper.createImageInfo(new ImageInfoDto(restaurantId, fileInfoDto.getId()));
		}

		List<MealKitDto> mealKits = campsiteDto.getMealKits();
		for (MealKitDto mealKit : mealKits){
			mealKit.setCampsiteId(campsiteId);
			mealKitMapper.createMealkit(mealKit);
			int mealKitId = mealKit.getId();
			FileInfoDto fileInfoDto = mealKit.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(mealKit.getImage());
			mealKitImageInfoMapper.createImageInfo(new ImageInfoDto(mealKitId, fileInfoDto.getId()));
		}

		List<TouristDto> touristInfos = campsiteDto.getTouristInfos();
		for (TouristDto touristInfo : touristInfos){
			touristInfo.setCampsiteId(campsiteId);
			touristMapper.createTourist(touristInfo);
			int touristId = touristInfo.getId();
			FileInfoDto fileInfoDto = touristInfo.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(touristInfo.getImage());
			touristImageInfoMapper.createImageInfo(new ImageInfoDto(touristId, fileInfoDto.getId()));
		}

		return createCnt;
	}

/*

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
	
*/
}
