package com.smu.camping.controller.campsite;

import com.smu.camping.service.campsite.CampsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampsiteInfoController {
	@Autowired
	CampsiteInfoService campsiteInfoService;

/*	public ApiResponse createCampsiteInfo(CampsiteDto campsiteDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse updateCampsiteInfo(CampsiteDto campsiteDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<CampsiteDto> getAllCampsiteInfo(){
		
	}
	
	public List<CampsiteDto> getCampsiteInfoByUserName(@AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public CampsiteDto getCampsiteInfoByCampsiteId(int CampsiteId){
		
	}
	
	public List<CampsiteDto> getCampsiteOrderByReviewNum(){
		
	}
	
	public List<CampsiteDto> getCampsiteInfoByFilter(SearchFilterDto searchFilterDto){
		
	}*/
}
