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
public class CreateQuestion1 {

	@Test
	void testCreateUser() {
		QuestionEntity ques = new QuestionEntity();
		AnswerEntity ans=new AnswerEntity();
		ques.setQuestionContent("Which of the following option leads to the portability and security of Java?");
		ques.setId(20);
		
		ans.setAnswerContent("Bytecode is executed by JVM");
		ans.setId(1);
		ans.setCorrect(true);
		
		ans.setAnswerContent("The applet makes the Java code secure and portable");
		ans.setId(2);
		ans.setCorrect(false);
		
		ans.setAnswerContent("Use of exception handling");
		ans.setId(3);
		ans.setCorrect(false);
		
		ans.setAnswerContent("Dynamic binding between objects");
		ans.setId(4);
		ans.setCorrect(false);
		
	}
}
