package com.microserviceanswer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceanswer.model.Answer;
import com.microserviceanswer.service.IAnswerService;

@RestController
public class AnswerController {

	@Autowired
	private IAnswerService answerService;
	
	@PostMapping
	public ResponseEntity<?> saveAll(@RequestBody Iterable<Answer> answers){
		return new ResponseEntity<>(this.answerService.saveAll(answers),HttpStatus.OK);
	}
	
	@GetMapping("/{idExam}/{idStudent}")
	public ResponseEntity<?> getByExamAndStudent(@PathVariable Long idExam, @PathVariable Long idStudent){
		return new ResponseEntity<>(this.answerService.findAnswerByStudentByExam(idExam, idStudent),HttpStatus.OK);
	}
}
