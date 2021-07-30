package com.microserviceanswer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.commonexams.model","com.springboot.app.model","com.microserviceanswer.model"})
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceAnswerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAnswerApplication.class, args);
	}

}
