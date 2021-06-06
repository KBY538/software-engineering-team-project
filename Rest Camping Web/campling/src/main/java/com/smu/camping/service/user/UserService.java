package com.smu.camping.service.user;

import com.smu.camping.mapper.user.UserMapper;
import com.smu.camping.mapper.user.UserRoleMapper;
import com.smu.camping.dto.user.UserDto;
import com.smu.camping.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	UserRoleMapper userRoleMapper;

	private final String ROLE_CAMPER = "ROLE_CAMPER";
	private final String ROLE_OWNER= "ROLE_OWNER";
	private final String ROLE_ADMIN = "ROLE_ADMIN";

	public UserDto getUserInfoByUsername(String username){
		return userMapper.getUserInfoByUsername(username);
	}

	public List<UserRoleDto> getUserRolesByUsername(String username){
		return userRoleMapper.getUserRolesByUsername(username);
	}

	@Transactional(readOnly = false)
	public int createNewUser(UserDto userDto){
		String username = userDto.getUsername();
		UserRoleDto userRole = new UserRoleDto(username, ROLE_CAMPER);

		userMapper.createUserInfo(userDto);
		return userRoleMapper.createUserRole(userRole);
	}

	@Transactional(readOnly = true)
	public boolean usernameValidation(String username){
		UserDto userDto = userMapper.getUserInfoByUsername(username);

		return (userDto == null);
	}
/*
	public List<UserDto> getAlluserInfo(){

	}

	@Transactional(readOnly = false)
	public int updateUserInfo(UserDto){

	}

	@Transactional(readOnly = false)
	public int deleteUserInfo(String username){

	}

	@Transactional(readOnly = false)
	public int createUserRole(UserRoleDto){

	}

	@Transactional(readOnly = false)
	public int deleteUserRole(String username, String roleName){

	}*/
}
