package com.example.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude=DataSourceAutoConfiguration.class,scanBasePackages ="com.example.bootdemo.controller")
@SpringBootApplication (scanBasePackages ="com.example.bootdemo.controller")

@EntityScan(basePackages="com.example.bootdemo.dto")
@EnableJpaRepositories(basePackages="com.example.bootdemo.repository")
public class BootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootdemoApplication.class, args);
	}

}
