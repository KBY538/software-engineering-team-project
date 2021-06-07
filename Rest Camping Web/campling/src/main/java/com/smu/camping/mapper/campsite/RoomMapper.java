package com.smu.camping.mapper.campsite;

import com.smu.camping.dto.campsite.RoomDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {
	public int createRoom(RoomDto roomDto);
	public int updateRoom(RoomDto roomDto);
	public int deleteRoom(int roomId);
	public RoomDto getRoom(int roomId);
	public List<RoomDto> getRoomByCampsiteId(int campsiteId);
}
