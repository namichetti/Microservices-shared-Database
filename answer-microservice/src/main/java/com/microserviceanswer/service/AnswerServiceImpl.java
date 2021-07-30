package com.microserviceanswer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microserviceanswer.model.Answer;
import com.microserviceanswer.repository.IAnswerRepository;

@Service
public class AnswerServiceImpl implements IAnswerService {
	
	@Autowired
	private IAnswerRepository answerRepository;

	@Override
	@Transactional
	public Iterable<Answer> saveAll(Iterable<Answer> answers) {
		return answerRepository.saveAll(answers);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Answer> findAnswerByStudentByExam(Long idExam, Long idStudent) {
		return this.answerRepository.findAnswerByStudentByExam(idExam, idStudent);
	}

}
