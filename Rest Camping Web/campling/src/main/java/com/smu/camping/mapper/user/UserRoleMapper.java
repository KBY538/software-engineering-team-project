package com.smu.camping.mapper.user;

import com.smu.camping.dto.user.UserRoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
	 List<UserRoleDto> getUserRolesByUsername(String username);
	 int createUserRole(UserRoleDto userRoleDto);
	 int deleteUserRole(String username, String roleName);
}
