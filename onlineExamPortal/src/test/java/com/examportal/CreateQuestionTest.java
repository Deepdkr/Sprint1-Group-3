package com.examportal;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;

import com.examportal.entities.AnswerEntity;
import com.examportal.entities.QuestionEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CreateQuestionTest {

	@Test
	void testCreateUser() {
		QuestionEntity ques = new QuestionEntity();
		AnswerEntity ans=new AnswerEntity();
		ques.setQuestionContent("which of the following option is not a java feature?");
		ques.setId(12);
		
		ans.setAnswerContent("dynamic");
		ans.setId(1);
		ans.setCorrect(false);
		
		ans.setAnswerContent("Architecture Neutral");
		ans.setId(2);
		ans.setCorrect(false);
		
		ans.setAnswerContent("Use of pointers");
		ans.setId(3);
		ans.setCorrect(true);
		
		ans.setAnswerContent("Object-oriented");
		ans.setId(4);
		ans.setCorrect(false);
		
	}
}
