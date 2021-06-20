package com.smu.camping.service.post.marker;

import com.smu.camping.dto.post.marker.MarkerDto;
import com.smu.camping.mapper.campsite.MarkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarkerService {
	@Autowired
	private MarkerMapper markerMapper;
	
/*	public int createMarker(MarkerDto markerDto){
		
	}

	public int updateMarker(MarkerDto markerDto){
		
	}

	public int deleteMarker(int markerId){
		
	}

	@Transactional(readOnly = true)
	public List<MarkerDto> getMarkerByUsername(String username){
		
	}

	@Transactional(readOnly = true)
	public MarkerDto getMarkerByMarkerId(int markerId){
		
	}*/
}
