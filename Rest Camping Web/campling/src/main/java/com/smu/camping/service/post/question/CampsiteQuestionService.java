package com.smu.camping.service.post.question;

import com.smu.camping.mapper.post.question.CampsiteQuestionCommentMapper;
import com.smu.camping.mapper.post.question.CampsiteQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampsiteQuestionService {
	@Autowired
	CampsiteQuestionMapper campsiteQuestionMapper;

	@Autowired
	CampsiteQuestionCommentMapper campsiteQuestionCommentMapper;
/*
	@Transactional(readOnly = false)
	public int createQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto) {
		
	}

	@Transactional(readOnly = false)
	public int deleteQuestionCommentByQuestionCommentId(int QuestionCommentId) {
		
	}

	@Transactional(readOnly = false)
	public int updateQuestionComment(CampsiteQuestionCommentDto campsiteQuestionCommentDto) {
		
	}
	
	@Transactional(readOnly = false)
	public int createQuestion(CampsiteQuestionDto campsiteQuestionDto) {
		
	}

	@Transactional(readOnly = false)
	public int deleteQuestion(int questionId) {
		
	}

	@Transactional(readOnly = false)
	public int updateQuestion(CampsiteQuestionDto campsiteQuestionDto){
		
	}
	
	public List<CampsiteQuestionDto> getCampsiteQuestionByUserName(String writer){
		
	}

	public List<CampsiteQuestionDto> getCampsiteQuestionByCampsiteId(int campsiteId) {
		
	}*/
}
