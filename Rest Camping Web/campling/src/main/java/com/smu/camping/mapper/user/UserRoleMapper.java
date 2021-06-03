package com.smu.camping.mapper.user;

import com.smu.camping.dto.user.UserRoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
	public List<UserRoleDto> getUserRolesByUsername(String username);
	public int createUserRole(UserRoleDto userRoleDto);
	public int deleteUserRole(String username, String roleName);
}
