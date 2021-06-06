package com.smu.camping.mapper.user;

import com.smu.camping.dto.user.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	 UserDto getUserInfoByUsername(String username);
	 List<UserDto> getAllUserInfo();
	 int createUserInfo(UserDto userDto);
	 int updateUserInfo(UserDto userDto);
	 int deleteUserInfo(String username);
}
