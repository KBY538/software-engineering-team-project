package com.smu.camping.mapper.post.community;

import com.smu.camping.dto.post.community.CommunityCommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityCommentMapper {
	public int createCommunityComment(CommunityCommentDto communityCommentDto);
	public int updateCommunityComment(CommunityCommentDto communityCommentDto);
	public int deleteCommunityComment(int postId);
	public List<CommunityCommentDto> getCommunityCommentByWriter(String writer);
	public List<CommunityCommentDto> getCommunityCommentByPostId(int postId);
}
