package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.post.marker.MarkerDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkerMapper {
	public int createMarker(MarkerDto markerDto);
	public int updateMarker(MarkerDto markerDto);
	public int deleteMarker(int markerId);
	public List<MarkerDto> getMarkerByUsername(String username);
	public MarkerDto getMarkerByMarkerId(int markerId);
}
