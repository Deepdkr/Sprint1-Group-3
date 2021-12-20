package com.examportal.service;

import com.examportal.Exception.QuestionNotFoundException;
import com.examportal.dto.AnswerDto;
import com.examportal.dto.QuestionDto;

import java.util.Set;

public interface QuestionService {

	QuestionDto createQuestion(QuestionDto questionDto) throws QuestionNotFoundException;

	Set<QuestionDto> getAllQuestions();

	QuestionDto getQuestionById(long id);

	QuestionDto updateAnswer(AnswerDto answerDto, long id);

	String deleteQuestionById(long id);
}
