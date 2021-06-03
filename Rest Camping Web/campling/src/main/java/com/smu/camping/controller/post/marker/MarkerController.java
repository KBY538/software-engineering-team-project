package com.smu.camping.controller.post.marker;

import com.smu.camping.service.post.marker.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController {
	@Autowired
	MarkerService markerService;
	
/*	public ApiResponse createMarker(@AuthenticationPrincipal CustomUserDetails userDetails, MarkerDto markerDto){
		
	}

	public ApiResponse updateMarker(@AuthenticationPrincipal CustomUserDetails userDetails, MarkerDto markerDto){
		
	}

	public ApiResponse deleteMarker(@AuthenticationPrincipal CustomUserDetails userDetails, int markerId){
		
	}
	
	public List<MarkerDto> getMarkerByUsername(@AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public MarkerDto getMarkerByMarkerId(@AuthenticationPrincipal CustomUserDetails userDetails, int markerId){
		
	}*/
}
