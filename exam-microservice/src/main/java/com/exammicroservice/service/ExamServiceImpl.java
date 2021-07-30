package com.exammicroservice.service;

import org.springframework.stereotype.Service;

import com.commonmicroservices.service.CommonServiceImpl;
import com.commonexams.model.Exam;
import com.exammicroservice.repository.IExamRepository;

@Service
public class ExamServiceImpl extends CommonServiceImpl<Exam, IExamRepository> implements IExamService{

}
