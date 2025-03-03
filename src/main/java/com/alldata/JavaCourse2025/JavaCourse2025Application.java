package com.alldata.JavaCourse2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan()
public class JavaCourse2025Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaCourse2025Application.class, args);
	}

}
