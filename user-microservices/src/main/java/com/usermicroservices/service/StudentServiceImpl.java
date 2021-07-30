package com.usermicroservices.service;

import com.commonmicroservices.exception.NotFoundException;
import com.commonmicroservices.service.CommonServiceImpl;
import com.springboot.app.model.Student;
import com.usermicroservices.repository.IStudentRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, IStudentRepository>implements IStudentService{

	@Override
	@Transactional(readOnly=true)
	public Optional<Student> findImageById(Long id) throws NotFoundException {
		Optional<Student> student = this.repository.findById(id);
		if(student.isEmpty() || student.get().getPhoto()==null) {
			throw new NotFoundException("Error to find image or student");
		}
		return student;
	}



	
}
