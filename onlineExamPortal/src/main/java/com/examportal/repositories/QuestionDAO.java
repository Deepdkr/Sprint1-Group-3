package com.examportal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examportal.entities.AnswerEntity;
import com.examportal.entities.QuestionEntity;

@Repository
public interface QuestionDAO extends CrudRepository<QuestionEntity, Long> {
	QuestionEntity findById(long id);

	QuestionEntity findByQuestionContent(String questionContent);

	AnswerEntity findByAnswers(String answerContent);
}
