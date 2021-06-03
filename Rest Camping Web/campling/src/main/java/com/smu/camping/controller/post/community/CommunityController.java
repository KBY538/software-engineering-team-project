package com.smu.camping.controller.post.community;

import com.smu.camping.service.post.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {
	@Autowired
	CommunityService communityService;

/*	public ApiResponse createCommunityPost(@AuthenticationPrincipal CustomUserDetails userDetails, CommunityPostDto communityPostDto){
		
	}

	public ApiResponse updateCommunityPost(@AuthenticationPrincipal CustomUserDetails userDetails, CommunityPostDto communityPostDto){
		
	}

	public ApiResponse deleteCommunityPost(@AuthenticationPrincipal CustomUserDetails userDetails, int id){
		
	}

	public ApiResponse createCommunityComment(@AuthenticationPrincipal CustomUserDetails userDetails, CommunityCommentDto communityCommentDto){
		
	}

	public ApiResponse updateCommunityComment(@AuthenticationPrincipal CustomUserDetails userDetails, CommunityCommentDto communityCommentDto){
		
	}

	public ApiResponse deleteCommunityComment(@AuthenticationPrincipal CustomUserDetails userDetails, int postId){
		
	}
	
	public List<CommunityPostDto> getAllCommunityPost(){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByUsername(@AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByPostId(int postId){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByCommentWriter(String commentWriter) {

	}*/
}
