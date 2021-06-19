package com.smu.camping.service.campsite;

import com.smu.camping.dto.campsite.ImageInfoDto;
import com.smu.camping.dto.campsite.RestaurantDto;
import com.smu.camping.dto.campsite.RoomDto;
import com.smu.camping.dto.file.FileInfoDto;
import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.campsite.imageInfoMapper.RoomImageInfoMapper;
import com.smu.camping.mapper.file.FileInfoMapper;
import com.smu.camping.mapper.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

	public int getCheapestRoomByCampsiteId(int campsiteId){
		return roomMapper.getCheapestRoomByCampsiteId(campsiteId);
	}

	@Transactional(readOnly = true)
	public List<RoomDto> getRoomByCampsiteId(int campsiteId){

		List<RoomDto> roomDtos = roomMapper.getRoomByCampsiteId(campsiteId);
		for (RoomDto roomDto : roomDtos){
			int roomId = roomDto.getId();
			ImageInfoDto imageInfoDto = roomImageInfoMapper.getImageInfoById(roomId);
			FileInfoDto fileInfoDto = fileInfoMapper.getFileInfo(imageInfoDto.getImageId());
			roomDto.setImage(fileInfoDto);
		}

		return roomDtos;
	}

	public int createRooms(List<RoomDto> roomDtos, int campsiteId, String owner){
		int createCnt = 0;

		for (RoomDto room : roomDtos){
			room.setCampsiteId(campsiteId);
			int roomId = room.getId();

			createCnt += roomMapper.createRoom(room);
			FileInfoDto fileInfoDto = room.getImage();
			fileInfoDto.setUsername(owner);
			fileInfoMapper.createFileInfos(fileInfoDto);
			roomImageInfoMapper.createImageInfo(new ImageInfoDto(roomId, fileInfoDto.getId()));
		}

		return createCnt;
	}

	@Transactional(readOnly = true)
	public RoomDto getRoomByRoomId(int roomId){
		return roomMapper.getRoom(roomId);
	}

/*
	@Transactional(readOnly = false)
	public int updateRoom(List<RoomDto> roomDtos, List<MultipartFile> multipartFiles){
		
	}

	@Transactional(readOnly = false)
	public int deleteRoom(int roomId){
		
	}
	
	public RoomDto getRoom(int roomId){
		
	}*/
}

