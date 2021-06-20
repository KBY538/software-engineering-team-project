package com.smu.camping.controller.campsite;

import com.smu.camping.service.campsite.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TouristController {
	@Autowired
	private TouristService touristService;

/*	public ApiResponse createTourists(List<TouristDto> touristDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse updateTourist(List<TouristDto> touristDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse deleteTourist(int touristId){
		
	}
	
	public TouristDto getTourist(int touristId){
		
	}*/
}
