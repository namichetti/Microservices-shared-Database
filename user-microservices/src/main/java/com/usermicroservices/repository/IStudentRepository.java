package com.usermicroservices.repository;

import com.springboot.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student,Long> {
}
