package com.smu.camping.service.post.marker;

import com.smu.camping.mapper.campsite.MarkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkerService {
	@Autowired
	MarkerMapper markerMapper;
	
/*	@Transactional(readOnly = false)
	public int createMarker(MarkerDto markerDto){
		
	}
	@Transactional(readOnly = false)
	public int updateMarker(MarkerDto markerDto){
		
	}
	@Transactional(readOnly = false)
	public int deleteMarker(int markerId){
		
	}
	
	public List<MarkerDto> getMarkerByUsername(String username){
		
	}
	
	public MarkerDto getMarkerByMarkerId(int markerId){
		
	}*/
}
