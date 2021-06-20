package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.*;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.*;
import com.smu.camping.mapper.campsite.imageInfoMapper.*;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampsiteInfoService{
	@Autowired
	private CampsiteInfoMapper campsiteInfoMapper;

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private MealKitService mealKitService;

	@Autowired
	private RoomService roomService;
	
	@Autowired
	private TouristService touristService;

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Autowired
	private FileUtil fileUtil;

	@Autowired
	private CampsiteImageInfoMapper campsiteImageInfoMapper;

	@Autowired
	private FacilityMapper facilityMapper;

	@Autowired
	private OperatingMapper operatingMapper;

	@Autowired
	private CampsiteReviewMapper campsiteReviewMapper;

	@Autowired
	private MealKitImageInfoMapper mealKitImageInfoMapper;

	@Autowired
	private RestaurantImageInfoMapper restaurantImageInfoMapper;

	@Autowired
	private RoomImageInfoMapper roomImageInfoMapper;

	@Autowired
	private TouristImageInfoMapper touristImageInfoMapper;

	@Transactional(readOnly = true)
	public CampsiteDto getCampsiteInfoByCampsiteId(int CampsiteId){
		CampsiteDto campsiteDto = campsiteInfoMapper.getCampsiteInfoByCampsiteId(CampsiteId);

		int campsiteId = campsiteDto.getId();
		ImageInfoDto imageInfoDto = campsiteImageInfoMapper.getImageInfoById(campsiteId);
		int imageId = imageInfoDto.getImageId();

		campsiteDto.setMealKits(mealKitService.getMealKitsByCampsiteId(campsiteId));
		campsiteDto.setRestaurantInfos(restaurantService.getRestaurantByCampsiteId(campsiteId));
		campsiteDto.setTouristInfos(touristService.getTouristByCampsiteId(campsiteId));
		campsiteDto.setRooms(roomService.getRoomByCampsiteId(campsiteId));
		campsiteDto.setImage(fileInfoMapper.getFileInfo(imageId));

		campsiteDto.setCheapestRoomPrice(roomService.getCheapestRoomByCampsiteId(campsiteId));
		campsiteDto.setOperatingTypes(operatingMapper.getCampsiteOperatingByCampsiteId(campsiteId));
		campsiteDto.setFacilities(facilityMapper.getCampsiteFacilityByCampsiteId(campsiteId));

		return campsiteDto;
	}

	@Transactional(readOnly = true)
	public List<CampsiteDto> getCampsiteInfoByFilter(SearchFilterDto searchFilterDto){
		List<CampsiteDto> campsiteDtoList = campsiteInfoMapper.getCampsiteInfoByFilter(searchFilterDto);
		List<CampsiteDto> resultCampsiteResultList = new ArrayList<>();

		for (CampsiteDto campsiteDto : campsiteDtoList){
			int campsiteId = campsiteDto.getId();
			resultCampsiteResultList.add(getCampsiteInfoByCampsiteId(campsiteId));
		}

		return resultCampsiteResultList;
	}

	public int createCampsiteInfo(CampsiteDto campsiteDto){
		int createCnt = campsiteInfoMapper.createCampsiteInfo(campsiteDto);
		int campsiteId = campsiteDto.getId();
		String owner = campsiteDto.getOwner();

		facilityMapper.createCampsiteFacility(campsiteId, campsiteDto.getFacilities());
		operatingMapper.createCampsiteOperating(campsiteId, campsiteDto.getOperatingTypes());

		FileInfoDto campsiteFileInfoDto = campsiteDto.getImage();
		campsiteFileInfoDto.setUsername(owner);
		fileInfoMapper.createFileInfos(campsiteFileInfoDto);
		campsiteImageInfoMapper.createImageInfo(new ImageInfoDto(campsiteId, campsiteFileInfoDto.getId()));

		List<RoomDto> rooms = campsiteDto.getRooms();
		roomService.createRooms(rooms, campsiteId, owner);

		List<RestaurantDto> restaurantInfos = campsiteDto.getRestaurantInfos();
		System.out.println(restaurantInfos);
		restaurantService.createRestaurants(restaurantInfos, campsiteId, owner);

		List<MealKitDto> mealKits = campsiteDto.getMealKits();
		mealKitService.createMealKits(mealKits, campsiteId, owner);

		List<TouristDto> tourists = campsiteDto.getTouristInfos();
		touristService.createTourists(tourists, campsiteId, owner);

		return createCnt;
	}

/*

	public int updateCampsiteInfo(CampsiteDto campsiteDto){
		
	}

	@Transactional(readOnly = true)
	public List<CampsiteDto> getAllCampsiteInfo(){
		
	}

	@Transactional(readOnly = true)
	public CampsiteDto getCampsiteInfoByUserName(String owner){
		
	}

	@Transactional(readOnly = true)
	public List<CampsiteDto> getCampsiteOrderByReviewNum(){
		
	}
	
*/
}
