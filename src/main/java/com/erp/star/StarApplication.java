package com.erp.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StarApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarApplication.class, args);
	}
}
