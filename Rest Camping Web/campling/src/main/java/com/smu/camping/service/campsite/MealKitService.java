package com.smu.camping.service.campsite;

import com.smu.camping.mapper.campsite.MealKitMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.MealKitImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.util.FileUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
/*	@Transactional(readOnly = false)
	public int createMealKits(List<MealKitDto> mealKitDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int updateMealKits(List<MealKitDto> mealKitDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteMealKit(int mealKitId){
		
	}
	
	public MealKitDto getMealKit(int mealKitId){
		
	}*/
}
