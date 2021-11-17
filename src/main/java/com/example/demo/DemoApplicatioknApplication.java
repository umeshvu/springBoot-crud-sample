package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example.*")
@EntityScan("com.example.enity")
@EnableJpaRepositories("com.example.repository")
@EnableSwagger2
//@EnableScheduling
public class DemoApplicatioknApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplicatioknApplication.class, args);
	}

}
