package com.smu.camping.controller.post.notice;

import com.smu.camping.service.post.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
/*	public ApiResponse createNotice(@AuthenticationPrincipal CustomUserDetails userDetails, NoticeDto noticeDto){
		
	}

	public ApiResponse deleteNotice(@AuthenticationPrincipal CustomUserDetails userDetails, int noticeId){
		
	}

	public ApiResponse updateNotice(@AuthenticationPrincipal CustomUserDetails userDetails, NoticeDto noticeDto){
		
	}
	
	public NoticeDto getNoticeById(int noticeId){
		
	}
	
	public List<NoticeDto> getAllNotice(){
		
	}*/
}
