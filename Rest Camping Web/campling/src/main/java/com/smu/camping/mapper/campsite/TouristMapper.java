package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.campsite.TouristDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TouristMapper {
	public int createTourists(List<TouristDto> touristDtos);
	public int updateTourist(TouristDto touristDto);
	public int deleteTourist(int touristId);
	public TouristDto getTourist(int touristId);
	public List<TouristDto> getTouristByCampsiteId(int campsiteId);
}
