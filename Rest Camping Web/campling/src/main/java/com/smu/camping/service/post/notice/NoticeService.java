package com.smu.camping.service.post.notice;

import com.smu.camping.dto.post.notice.NoticeDto;
import com.smu.camping.mapper.post.notice.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
	@Autowired
	NoticeMapper noticeMapper;

/*	public int createNotice(NoticeDto noticeDto){

	}

	public int deleteNotice(int noticeId){

	}

	public int updateNotice(NoticeDto noticeDto){

	}

	@Transactional(readOnly = true)
	public NoticeDto getNoticeById(int noticeId){

	}

	@Transactional(readOnly = true)
	public List<NoticeDto> getAllNotice(){

	}*/
}
