package com.smu.camping.service.post.community;

import com.smu.camping.mapper.post.community.CommunityCommentMapper;
import com.smu.camping.mapper.post.community.CommunityPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	@Autowired
	private CommunityPostMapper communityPostMapper;
	
	@Autowired
	private CommunityCommentMapper communityCommentMapper;
	
/*
	public int createCommunityPost(CommunityPostDto communityPostDto){
		
	}

	public int updateCommunityPost(CommunityPostDto communityPostDto){
		
	}

	public int deleteCommunityPost(int postId){
		
	}

	public int createCommunityComment(CommunityCommentDto communityCommentDto){
		
	}

	public int updateCommunityComment(CommunityCommentDto communityCommentDto){
		
	}

	public int deleteCommunityComment(int postId){
		
	}

	@Transactional(readOnly = true)
	public List<CommunityPostDto> getAllCommunityPost(){
		
	}

	@Transactional(readOnly = true)
	public List<CommunityPostDto> getCommunityPostByUsername(String writer){
		
	}

	@Transactional(readOnly = true)
	public List<CommunityPostDto> getCommunityPostByPostId(int postId){
		
	}

	@Transactional(readOnly = true)
	public List<CommunityPostDto> getCommunityPostByCommentWriter(String commentWriter) {

	}*/
}
