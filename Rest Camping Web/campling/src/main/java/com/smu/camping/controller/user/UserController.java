package com.smu.camping.controller.user;

import com.smu.camping.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;

/*	public ApiResponse signUp(UserDto userDto){
		
	}

	public ApiResponse updateUserInfo(UserDto userDto){
		
	}

	public ApiResponse deleteUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails , String username){
		
	}
	
	public UserDto getUserInfoByUsername(@AuthenticationPrincipal CustomUserDetails userDetails, String username){
		
	}
	
	public List<UserDto> getAllUserInfo(){
		
	}
	
	public ApiResponse grantOwnerAuthority(String username){
		
	}*/
}
