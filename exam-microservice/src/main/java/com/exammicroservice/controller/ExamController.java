package com.exammicroservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.commonmicroservices.controller.CommonController;
import com.commonexams.model.Exam;
import com.exammicroservice.service.IExamService;

@RestController
public class ExamController extends CommonController<Exam, IExamService>{

}
