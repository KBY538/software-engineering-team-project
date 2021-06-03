package com.smu.camping.mapper.post.review;

import com.smu.camping.dto.post.review.ReviewDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampsiteReviewMapper {
	public int createReview(ReviewDto reviewDto);
	public int deleteReview(int reviewId);
	public int updateReview(ReviewDto reviewDto);
	public List<ReviewDto> getReviewByUserName(String username);
	public List<ReviewDto> getReviewByCampsiteId(int campsiteId);
}
