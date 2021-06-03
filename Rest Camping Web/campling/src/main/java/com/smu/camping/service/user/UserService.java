package com.smu.camping.service.user;

import com.smu.camping.mapper.user.UserMapper;
import com.smu.camping.mapper.user.UserRoleMapper;
import com.smu.camping.dto.user.UserDto;
import com.smu.camping.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	UserRoleMapper userRoleMapper;
	public UserDto getUserInfoByUsername(String username){
		return userMapper.getUserInfoByUsername(username);
	}

	public List<UserRoleDto> getUserRolesByUsername(String username){
		return userRoleMapper.getUserRolesByUsername(username);
	}

/*
	public List<UserDto> getAlluserInfo(){

	}

	@Transactional(readOnly = false)
	public int createUserInfo(UserDto){

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
