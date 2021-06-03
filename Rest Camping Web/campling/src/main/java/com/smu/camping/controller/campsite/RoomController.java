package com.smu.camping.controller.campsite;

import com.smu.camping.service.campsite.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	@Autowired
	RoomService roomservice;

/*	public ApiResponse createRooms(List<RoomDto> roomDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse updateRoom(List<RoomDto> roomDtos, List<MultipartFile> multipartFiles){
		
	}

	public ApiResponse deleteRoom(int roomId){
		
	}
	
	public RoomDto getRoom(int roomId){
		
	}*/
}
