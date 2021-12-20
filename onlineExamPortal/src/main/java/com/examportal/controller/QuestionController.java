package com.examportal.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.examportal.Exception.QuestionNotFoundException;
import com.examportal.dto.AnswerDto;
import com.examportal.dto.QuestionDto;
import com.examportal.model.AnswerRequestModel;
import com.examportal.model.QuestionRequestModel;
import com.examportal.model.QuestionResponseModel;
import com.examportal.service.QuestionService;

import java.util.HashSet;
import java.util.Set;

@RestController

public class QuestionController {

	@Autowired
	QuestionService questionService;

	private ModelMapper modelMapper = new ModelMapper();

	@PostMapping("createQuestion")
	public QuestionResponseModel createQuestion(@RequestBody QuestionRequestModel question) throws QuestionNotFoundException {
		QuestionDto questionDto = modelMapper.map(question, QuestionDto.class);

		return modelMapper.map(questionService.createQuestion(questionDto), QuestionResponseModel.class);

	}

	@GetMapping(path = "/{id}")

	public QuestionResponseModel getQuestionById(@PathVariable long id) {
		return modelMapper.map(questionService.getQuestionById(id), QuestionResponseModel.class);
	}

	@GetMapping(value = "getAllQuestions")
	public Set<QuestionResponseModel> getAllQuestions() {
		Set<QuestionResponseModel> returnValue = new HashSet<>();
		for (QuestionDto questionDto : questionService.getAllQuestions()) {
			QuestionResponseModel questionResponseModel = modelMapper.map(questionDto, QuestionResponseModel.class);
			returnValue.add(questionResponseModel);
		}

		return returnValue;
	}

	@DeleteMapping(path = "/{id}")

	public String deleteQuestionById(@PathVariable long id) {

		questionService.deleteQuestionById(id);
		return "Question was successfully deleted";

	}

	@PutMapping(path = "/{id}")

	public QuestionResponseModel addAnswerToQuestion(@PathVariable long id, @RequestBody AnswerRequestModel answer) {

		AnswerDto answerToAdd = modelMapper.map(answer, AnswerDto.class);

		return modelMapper.map(questionService.updateAnswer(answerToAdd, id), QuestionResponseModel.class);

	}

}
