package com.smu.camping.mapper.post.question;

import com.smu.camping.dto.post.question.CampsiteQuestionCommentDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CampsiteQuestionCommentMapper {
	public int createQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto) ;
	public int deleteQuestionCommentByQuestionCommentId(int QuestionCommentId) ;
	public int updateQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto);
	public CampsiteQuestionCommentDto getQuestionCommentByQuestionId(int questionId) ;
}
