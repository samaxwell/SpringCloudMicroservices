package com.sean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@RefreshScope
@SpringBootApplication
public class BlogWriterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogWriterServiceApplication.class, args);
	}

}
