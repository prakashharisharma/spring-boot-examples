package com.tutorialsdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SleuthZipkinApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SleuthZipkinApp.class, args);
	}

	@Bean
	public AlwaysSampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
	
}
