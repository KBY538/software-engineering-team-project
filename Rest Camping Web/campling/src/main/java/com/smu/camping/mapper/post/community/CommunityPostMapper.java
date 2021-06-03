package com.smu.camping.mapper.post.community;

import com.smu.camping.dto.ApiResponse;
import com.smu.camping.dto.post.community.CommunityPostDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityPostMapper {
	public ApiResponse createCommunityPost(CommunityPostDto communityPostDto);
	public ApiResponse updateCommunityPost(CommunityPostDto communityPostDto);
	public ApiResponse deleteCommunityPost(int postId);
	public List<CommunityPostDto> getAllCommunityPost();
	public List<CommunityPostDto> getCommunityPostByWriter(String writer);
	public List<CommunityPostDto> getCommunityPostByPostId(int postId);
}
