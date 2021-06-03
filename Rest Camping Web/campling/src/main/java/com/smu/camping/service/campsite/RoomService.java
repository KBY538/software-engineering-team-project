package com.smu.camping.service.campsite;

import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.RoomImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService{
	@Autowired
	RoomMapper roomMapper;
	
	@Autowired
	RoomImageInfoMapper roomImageInfoMapper;
	
	@Autowired
	FileInfoMapper fileInfoMapper;
	
	@Autowired
	FileUtil fileUtil;
	
/*	@Transactional(readOnly = false)
	public int createRooms(List<RoomDto> roomDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int updateRoom(List<RoomDto> roomDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteRoom(int roomId){
		
	}
	
	public RoomDto getRoom(int roomId){
		
	}*/
}

