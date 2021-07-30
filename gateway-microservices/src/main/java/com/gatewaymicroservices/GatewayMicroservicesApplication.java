package com.gatewaymicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayMicroservicesApplication.class, args);
	}

}
