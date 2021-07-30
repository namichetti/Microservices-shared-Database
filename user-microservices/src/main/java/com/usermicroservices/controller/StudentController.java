package com.usermicroservices.controller;

import org.springframework.http.MediaType;
import com.commonmicroservices.controller.CommonController;
import com.commonmicroservices.exception.NotFoundException;
import com.springboot.app.model.Student;
import com.usermicroservices.service.IStudentService;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class StudentController extends CommonController<Student, IStudentService>{
	

    @PostMapping("/image")
    public ResponseEntity<?> savePhoto(Student student, @RequestParam MultipartFile file) {
    	if(!file.isEmpty()) {
    		try {
				student.setPhoto(file.getBytes());
			} catch (IOException e) {
				log.error(e.getMessage());
			}
    	}
    	return super.save(student);
    }
    
    //Falta el PUT
    
    
    @GetMapping("/image/{id}")
    public ResponseEntity<?> findImageyId(@PathVariable Long id) throws NotFoundException{
    	Optional<Student> student = this.service.findImageById(id);
    	Resource resource = new ByteArrayResource(student.get().getPhoto());
    	return  ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }

}
