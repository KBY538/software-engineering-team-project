package com.smu.camping.controller.campsite;

import com.smu.camping.service.campsite.MealKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealKitController {
	@Autowired
	MealKitService mealkitService;

/*	public ApiResponse createMealKits(List<MealKitDto> mealKitDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse updateMealKits(List<MealKitDto> mealKitDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse deleteMealKit(int mealKitId){
		
	}
	
	public MealKitDto getMealKit(int mealKitId){
		
	}*/
}
