package com.example.demotracing;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTracingApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(DemoTracingApplication.class, args);
	}

}
