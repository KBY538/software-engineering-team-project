package com.smu.camping.service.user;

import com.smu.camping.dto.user.CustomUserDetails;
import com.smu.camping.dto.user.UserDto;
import com.smu.camping.dto.user.UserRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userService.getUserInfoByUsername(username);

		if(userDto == null){
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		}

		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setUsername(userDto.getUsername());
		customUserDetails.setPassword(userDto.getPassword());

		List<UserRoleDto> userRoleList = userService.getUserRolesByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<>();

		if(userRoleList != null){
			for(UserRoleDto userRole : userRoleList){
				authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
			}
		}

		// CustomUserDetails 객체에 권한 목록 (authorities)를 설정한다.
		customUserDetails.setAuthorities(authorities);
		customUserDetails.setEnabled(true);
		customUserDetails.setAccountNonExpired(true);
		customUserDetails.setAccountNonLocked(true);
		customUserDetails.setCredentialsNonExpired(true);

		return customUserDetails;
	}
}
