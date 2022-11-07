package com.cm.rh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 
public class ServiceRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRhApplication.class, args);
	}

}
