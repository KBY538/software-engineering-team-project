package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.ImageInfoDto;
import com.smu.camping.dto.campsite.MealKitDto;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.MealKitMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.MealKitImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MealKitService{
	@Autowired
	MealKitMapper mealKitMapper;

	@Autowired
	MealKitImageInfoMapper mealKitImageInfoMapper;
	
	@Autowired
	FileInfoMapper fileInfoMapper;
	
	@Autowired
	FileUtil fileUtil;

	@Transactional(readOnly = false)
	public int createMealKits(List<MealKitDto> mealKitDtos, int campsiteId, String owner){
		int createCnt = 0;

		for (MealKitDto mealKitDto : mealKitDtos){
			mealKitDto.setCampsiteId(campsiteId);
			createCnt += mealKitMapper.createMealkit(mealKitDto);
			int roomId = mealKitDto.getId();
			FileInfoDto fileInfoDto = mealKitDto.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(fileInfoDto);
			mealKitImageInfoMapper.createImageInfo(new ImageInfoDto(roomId, fileInfoDto.getId()));
		}

		return createCnt;
	}

/*
	@Transactional(readOnly = false)
	public int updateMealKits(List<MealKitDto> mealKitDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteMealKit(int mealKitId){
		
	}
	
	public MealKitDto getMealKit(int mealKitId){
		
	}*/
}
