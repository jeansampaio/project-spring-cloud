package com.wynsoft.logaggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommentServiceApplication {

	public static void main(String[] args) {
		//System.setProperty("log.name", "comment-service");
		//System.setProperty("path.name", "./logs");
		//System.setProperty("logback.address","localhost:5000");
		SpringApplication.run(CommentServiceApplication.class, args);
	}
}
