package com.usermicroservices.service;

import java.util.Optional;

import com.commonmicroservices.exception.NotFoundException;
import com.commonmicroservices.service.ICommonService;
import com.springboot.app.model.Student;

public interface IStudentService extends ICommonService<Student>{
 
	public Optional<Student> findImageById(Long id) throws NotFoundException;

}
