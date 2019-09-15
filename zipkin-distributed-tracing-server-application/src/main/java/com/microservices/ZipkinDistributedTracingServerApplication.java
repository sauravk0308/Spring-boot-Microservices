package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;


@EnableZipkinStreamServer
@SpringBootApplication
public class ZipkinDistributedTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedTracingServerApplication.class, args);
	}

}
