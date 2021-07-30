package com.microservicecurse.model.service;

import org.springframework.http.ResponseEntity;
import com.commonmicroservices.service.ICommonService;
import com.microservicecurse.model.Curse;

public interface ICurseService extends ICommonService<Curse>{
	
	public ResponseEntity<?> getByExamAndStudent(Long idExam, Long idStudent);
}
