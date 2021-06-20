package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.ImageInfoDto;
import com.smu.camping.dto.campsite.TouristDto;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.TouristMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.TouristImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TouristService{
	@Autowired
	private TouristMapper touristMapper;
	
	@Autowired
	private TouristImageInfoMapper touristImageInfoMapper;
	
	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Autowired
	private FileUtil fileUtil;

	@Transactional(readOnly = true)
	public List<TouristDto> getTouristByCampsiteId(int campsiteId){

		List<TouristDto> touristDtos = touristMapper.getTouristByCampsiteId(campsiteId);

		for (TouristDto touristDto : touristDtos){
			int touristId = touristDto.getId();
			ImageInfoDto imageInfoDto = touristImageInfoMapper.getImageInfoById(touristId);
			FileInfoDto fileInfoDto = fileInfoMapper.getFileInfo(imageInfoDto.getImageId());
			touristDto.setImage(fileInfoDto);
		}

		return touristDtos;
	}

	public int createTourists(List<TouristDto> touristDtos, int campsiteId, String owner){
		int createCnt = 0;

		for (TouristDto touristDto : touristDtos){
			touristDto.setCampsiteId(campsiteId);
			createCnt += touristMapper.createTourist(touristDto);
			int roomId = touristDto.getId();
			FileInfoDto fileInfoDto = touristDto.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(fileInfoDto);
			touristImageInfoMapper.createImageInfo(new ImageInfoDto(roomId, fileInfoDto.getId()));
		}

		return createCnt;
	}

/*
	public int updateTourist(List<TouristDto> touristDtos, List<MultipartFile> multipartFiles){
		
	}

	public int deleteTourist(int touristId){
		
	}

	@Transactional(readOnly = true)
	public TouristDto getTourist(int touristId){
		
	}*/
}
