package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sist.web.controller","com.sist.web.dao","com.sist.web.entity","com.sist.web.manager"})
public class MyReduxProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyReduxProjectApplication.class, args);
	}

}
