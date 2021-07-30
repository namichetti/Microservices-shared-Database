package com.microserviceanswer.service;

import com.microserviceanswer.model.Answer;

public interface IAnswerService {

	public Iterable<Answer> saveAll(Iterable<Answer> answers);
	public Iterable<Answer> findAnswerByStudentByExam(Long idExam, Long idStudent);

}
