package com.exammicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.commonexams.model.Exam;


public interface IExamRepository extends CrudRepository<Exam, Long>{

}
