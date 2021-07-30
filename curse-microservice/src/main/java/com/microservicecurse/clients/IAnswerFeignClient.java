package com.microservicecurse.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "answer-microservice")
public interface IAnswerFeignClient {

	@GetMapping("/{idExam}/{idStudent}")
	public ResponseEntity<?> getByExamAndStudent(@PathVariable Long idExam, @PathVariable Long idStudent);
}
