package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.campsite.CampsiteDto;
import com.sun.jndi.toolkit.dir.SearchFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampsiteInfoMapper {
	public int createCampsiteInfo(CampsiteDto campsiteDto);
	public int updateCampsiteInfo(CampsiteDto campsiteDto);
	public List<CampsiteDto> getAllCampsiteInfo();
	public CampsiteDto getCampsiteInfoByUserName(String owner);
	public CampsiteDto getCampsiteInfoByCampsiteId(int CampsiteId);
	public List<CampsiteDto> getCampsiteOrderByReviewNum();
	public List<CampsiteDto> getCampsiteInfoByFilter(SearchFilter searchFilter);
	public int getCampsiteCntOfOwner(String owner);
}
