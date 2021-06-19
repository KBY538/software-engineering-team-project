package com.smu.camping.service.post.question;

import com.smu.camping.dto.post.question.CampsiteQuestionCommentDto;
import com.smu.camping.dto.post.question.CampsiteQuestionDto;
import com.smu.camping.mapper.post.question.CampsiteQuestionCommentMapper;
import com.smu.camping.mapper.post.question.CampsiteQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampsiteQuestionService {
	@Autowired
	CampsiteQuestionMapper campsiteQuestionMapper;

	@Autowired
	CampsiteQuestionCommentMapper campsiteQuestionCommentMapper;

/*	public int createQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto) {
		
	}

	public int deleteQuestionCommentByQuestionCommentId(int QuestionCommentId) {
		
	}

	public int updateQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto) {
		
	}

	public int createQuestion(CampsiteQuestionDto campsiteQuestionDto) {
		
	}

	public int deleteQuestion(int questionId) {
		
	}

	public int updateQuestion(CampsiteQuestionDto campsiteQuestionDto){
		
	}

	@Transactional(readOnly = true)
	public List<CampsiteQuestionDto> getCampsiteQuestionByUserName(String writer){
		
	}

	@Transactional(readOnly = true)
	public List<CampsiteQuestionDto> getCampsiteQuestionByCampsiteId(int campsiteId) {
		
	}*/
}
