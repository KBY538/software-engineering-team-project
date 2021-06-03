package com.smu.camping.mapper.post.review;

import com.smu.camping.dto.post.review.ReviewCommentDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CampsiteReviewCommentMapper {
	public int createReviewComment(ReviewCommentDto reviewCommentDto);
	public int deleteReviewComment(int reviewCommentId);
	public int updateReviewComment(ReviewCommentDto reviewCommentDto);
	public ReviewCommentDto getReviewCommentByReviewId(int reviewId);
}
