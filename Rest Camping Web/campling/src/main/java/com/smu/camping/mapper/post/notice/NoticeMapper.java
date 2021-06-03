package com.smu.camping.mapper.post.notice;

import com.smu.camping.dto.post.notice.NoticeDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
	public int createNotice(NoticeDto noticeDto);
	public int deleteNotice(int noticeId);
	public int updateNotice(NoticeDto noticeDto);
	public NoticeDto getNotice(int noticeId);
	public List<NoticeDto> getAllNotice();
}
