package com.smu.camping.service.campsite;

import com.smu.camping.mapper.campsite.TouristMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.TouristImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService{
	@Autowired
	TouristMapper touristMapper;
	
	@Autowired
	TouristImageInfoMapper touristImageInfoMapper;
	
	@Autowired
	FileInfoMapper fileInfoMapper;

	@Autowired
	FileUtil fileUtil;
/*
	@Transactional(readOnly = false)
	public int createTourists(List<TouristDto> touristDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int updateTourist(List<TouristDto> touristDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteTourist(int touristId){
		
	}
	
	public TouristDto getTourist(int touristId){
		
	}*/
}
