package com.microservicecurse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.commonmicroservices.controller.CommonController;
import com.microservicecurse.model.Curse;
import com.microservicecurse.model.service.ICurseService;

@RestController
public class CurseController extends CommonController<Curse, ICurseService>{
	
	
	@GetMapping("/{idExam}/{idStudent}")
	public ResponseEntity<?> getByExamAndStudent(@PathVariable Long idExam, @PathVariable Long idStudent){
		return new ResponseEntity<>(this.service.getByExamAndStudent(idExam, idStudent),HttpStatus.OK);
	}
}
