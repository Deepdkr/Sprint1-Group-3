package com.examportal.serviceimpl;

import com.examportal.entities.QuestionEntity;

import com.examportal.repositories.QuestionDAO;
import com.examportal.service.QuestionService;
import com.examportal.Exception.QuestionNotFoundException;
import com.examportal.constants.ExamPortalConstants;
import com.examportal.dto.AnswerDto;
import com.examportal.dto.QuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionDAO questionRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public QuestionDto createQuestion(QuestionDto question) throws QuestionNotFoundException {

		if (questionRepository.findByQuestionContent(question.getQuestionContent()) != null)
			throw new QuestionNotFoundException(ExamPortalConstants.QUESTION_ALREADY_EXISTS_IN_DB);

		for (AnswerDto answer : question.getAnswers()) {
			answer.setQuestion(question);
		}

		QuestionEntity questionEntity = modelMapper.map(question, QuestionEntity.class);
		QuestionDto returnValue = modelMapper.map(questionRepository.save(questionEntity), QuestionDto.class);

		return returnValue;
	}

	@Override
	public QuestionDto getQuestionById(long id) {

		return modelMapper.map(questionRepository.findById(id), QuestionDto.class);
	}

	@Override
	public String deleteQuestionById(long id) {
		questionRepository.deleteById(id);

		return "Question Deleted successfully";
	}

	@Override
	public Set<QuestionDto> getAllQuestions() {
		Set<QuestionDto> returnSet = new HashSet<>();
		for (QuestionEntity question : questionRepository.findAll()) {
			QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
			returnSet.add(questionDto);
		}
		return returnSet;
	}

	@Override
	public QuestionDto updateAnswer(AnswerDto answer, long id) {
		QuestionEntity question = questionRepository.findById(id);
		QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);
		questionDto.getAnswers().add(answer);
		QuestionEntity returnQuestion = questionRepository.save(modelMapper.map(questionDto, QuestionEntity.class));

		return modelMapper.map(returnQuestion, QuestionDto.class);
	}

}
