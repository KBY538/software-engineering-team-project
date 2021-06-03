package com.smu.camping.service.post.review;

import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewCommentMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampsiteReviewService {
	@Autowired
	CampsiteReviewMapper campsiteReviewMapper;
	
	@Autowired
	CampsiteReviewCommentMapper campsiteReviewCommentMapper;
	
	@Autowired
	RoomMapper roomMapper;
/*
	@Transactional(readOnly = false)
	public int createReview(ReviewDto reviewDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteReview(int reviewId){
		
	}

	@Transactional(readOnly = false)
	public int updateReview(ReviewDto reviewDto){
		
	}

	@Transactional(readOnly = false)
	public int createReviewComment(ReviewCommentDto reviewCommentDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteReviewComment(int reviewCommentId){
		
	}

	@Transactional(readOnly = false)
	public int updateReviewComment(ReviewCommentDto reviewCommentDto){
		
	}
	
	public List<ReviewDto> getReviewByUserName(String username){
		
	}
	
	public List<ReviewDto> getReviewByCampsiteId(int campsiteId){
		
	}*/
}
