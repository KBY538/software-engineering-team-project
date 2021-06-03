package com.smu.camping.mapper.user;

import com.smu.camping.dto.user.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	public UserDto getUserInfoByUsername(String username);
	public List<UserDto> getAllUserInfo();
	public int createUserInfo(UserDto userDto);
	public int updateUserInfo(UserDto userDto);
	public int deleteUserInfo(String username);
}
