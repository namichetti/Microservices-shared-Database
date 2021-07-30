package com.microserviceanswer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microserviceanswer.model.Answer;

public interface IAnswerRepository extends CrudRepository<Answer, Long> {
	
	@Query("SELECT a FROM Answer a"
			+ " INNER JOIN FETCH a.question q "
			+ " INNER JOIN FETCH a.student s "
			+ " INNER JOIN FETCH q.exam e "
			+ "WHERE e.id=?1 AND s.id=?2")
	public Iterable<Answer> findAnswerByStudentByExam(Long idExam, Long idStudent);

}
