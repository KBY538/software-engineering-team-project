package com.smu.camping.service.post.review;

import com.smu.camping.mapper.campsite.RoomMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewCommentMapper;
import com.smu.camping.mapper.post.review.CampsiteReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampsiteReviewService {
	@Autowired
	private CampsiteReviewMapper campsiteReviewMapper;
	
	@Autowired
	private CampsiteReviewCommentMapper campsiteReviewCommentMapper;
	
	@Autowired
	private RoomMapper roomMapper;

/*	public int createReview(ReviewDto reviewDto){
		
	}

	public int deleteReview(int reviewId){
		
	}

	public int updateReview(ReviewDto reviewDto){
		
	}

	public int createReviewComment(ReviewCommentDto reviewCommentDto){
		
	}

	public int deleteReviewComment(int reviewCommentId){
		
	}

	public int updateReviewComment(ReviewCommentDto reviewCommentDto){
		
	}

	@Transactional(readOnly = true)
	public List<ReviewDto> getReviewByUserName(String username){
		
	}

	@Transactional(readOnly = true)
	public List<ReviewDto> getReviewByCampsiteId(int campsiteId){
		
	}*/
}
