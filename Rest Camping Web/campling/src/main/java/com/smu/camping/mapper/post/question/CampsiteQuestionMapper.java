package com.smu.camping.mapper.post.question;

import com.smu.camping.dto.post.question.CampsiteQuestionDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampsiteQuestionMapper {
	public int createQuestion(CampsiteQuestionDto campsiteQuestionDto);
	public int deleteQuestion(int questionId) ;
	public int updateQuestion(CampsiteQuestionDto campsiteQuestionDto);
	public List<CampsiteQuestionDto> getCampsiteQuestionByUserName(String writer);
	public List<CampsiteQuestionDto> getCampsiteQuestionByCampsiteId(int campsiteId) ;
}
