package com.smu.camping.controller.campsite;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.dto.campsite.CampsiteDto;
import com.smu.camping.dto.campsite.SearchFilterDto;
import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.service.campsite.CampsiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CampsiteInfoController {
	@Autowired
	private CampsiteInfoService campsiteInfoService;

	@GetMapping("/campsite/search")
	public List<CampsiteDto> getCampsiteInfoByFilter(@RequestParam String campsiteName, @RequestParam List<String> facilities, @RequestParam List<String> operatings){
		SearchFilterDto searchFilterDto = new SearchFilterDto();
		searchFilterDto.setCampsiteName(campsiteName);
		searchFilterDto.setFacilities(facilities);
		searchFilterDto.setOperatings(operatings);

		return campsiteInfoService.getCampsiteInfoByFilter(searchFilterDto);
	}

	@PostMapping("/campsite")
	public ApiResponse createCampsiteInfo(@RequestBody CampsiteDto campsiteDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		String owner = userDetails.getUsername();

		campsiteDto.setOwner(owner);
		campsiteInfoService.createCampsiteInfo(campsiteDto);

		return new ApiResponse();
	}

/*

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
	
*/
}
