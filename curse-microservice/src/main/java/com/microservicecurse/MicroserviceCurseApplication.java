package com.microservicecurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EntityScan({"com.springboot.app.model","com.microservicecurse.model", "com.commonexams.model","com.microserviceanswer.model"})
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceCurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCurseApplication.class, args);
	}

}
