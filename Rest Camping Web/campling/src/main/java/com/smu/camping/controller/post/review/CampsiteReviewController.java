package com.smu.camping.controller.post.review;

import com.smu.camping.service.post.review.CampsiteReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampsiteReviewController {
	@Autowired
	private CampsiteReviewService campsiteReviewService;

/*	public ApiResponse createReview(ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse deleteReview(int reviewId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse updateReview(ReviewDto reviewDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse createReviewComment(ReviewCommentDto reviewCommentDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse deleteReviewComment(int reviewCommentId, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}

	public ApiResponse updateReviewComment(ReviewCommentDto reviewCommentDto, @AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<ReviewDto> getReviewByUserName(@AuthenticationPrincipal CustomUserDetails userDetails){
		
	}
	
	public List<ReviewDto> getReviewByCampsiteId(int campsiteId){
		
	}*/
}
