package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringBootRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRunner.class, args);
	}
}
