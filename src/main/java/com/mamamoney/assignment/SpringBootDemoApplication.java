package com.mamamoney.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootDemoApplication {


	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}