package com.smu.camping.service.post.community;

import com.smu.camping.mapper.post.community.CommunityCommentMapper;
import com.smu.camping.mapper.post.community.CommunityPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	@Autowired
	CommunityPostMapper communityPostMapper;
	
	@Autowired
	CommunityCommentMapper communityCommentMapper;
	
/*	@Transactional(readOnly = false)
	public int createCommunityPost(CommunityPostDto communityPostDto){
		
	}

	@Transactional(readOnly = false)
	public int updateCommunityPost(CommunityPostDto communityPostDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteCommunityPost(int postId){
		
	}

	@Transactional(readOnly = false)
	public int createCommunityComment(CommunityCommentDto communityCommentDto){
		
	}

	@Transactional(readOnly = false)
	public int updateCommunityComment(CommunityCommentDto communityCommentDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteCommunityComment(int postId){
		
	}
	
	public List<CommunityPostDto> getAllCommunityPost(){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByUsername(String writer){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByPostId(int postId){
		
	}
	
	public List<CommunityPostDto> getCommunityPostByCommentWriter(String commentWriter) {

	}*/
}
