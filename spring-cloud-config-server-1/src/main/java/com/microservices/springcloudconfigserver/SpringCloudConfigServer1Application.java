package com.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServer1Application.class, args);
	}

}