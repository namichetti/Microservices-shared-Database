package com.microservicecurse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.commonmicroservices.service.CommonServiceImpl;
import com.microservicecurse.clients.IAnswerFeignClient;
import com.microservicecurse.model.Curse;
import com.microservicecurse.repository.ICurseRepository;

@Service
public class CurseServiceImpl extends CommonServiceImpl<Curse, ICurseRepository>implements ICurseService {
	
	@Autowired
	private IAnswerFeignClient feignClient;

	@Override
	public ResponseEntity<?> getByExamAndStudent(Long idExam, Long idStudent) {
		return this.feignClient.getByExamAndStudent(idExam, idStudent);
	}



}
