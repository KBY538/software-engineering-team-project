package com.smu.camping.service.post.notice;

import com.smu.camping.mapper.post.notice.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;
/*
	@Transactional(readOnly = false)
	public int createNotice(NoticeDto noticeDto){
		
	}

	@Transactional(readOnly = false)
	public int deleteNotice(int noticeId){
		
	}

	@Transactional(readOnly = false)
	public int updateNotice(NoticeDto noticeDto){
		
	}
	
	public NoticeDto getNoticeById(int noticeId){
		
	}
	
	public List<NoticeDto> getAllNotice(){
		
	}*/
}
