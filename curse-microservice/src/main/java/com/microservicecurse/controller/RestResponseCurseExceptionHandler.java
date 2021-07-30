package com.microservicecurse.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

import com.commonmicroservices.controller.RestResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseCurseExceptionHandler extends RestResponseEntityExceptionHandler{

}
