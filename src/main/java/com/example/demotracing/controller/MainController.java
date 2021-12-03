package com.example.demotracing.controller;

import com.example.demotracing.DemoService;
import io.opentracing.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static java.lang.String.format;

@RestController
public class MainController {
	private final DemoService demoService;
	private final RestTemplate restTemplate;
	private final Tracer tracer;

	public MainController(DemoService demoService, RestTemplate restTemplate, Tracer tracer) {
		this.demoService = demoService;
		this.restTemplate = restTemplate;
		this.tracer = tracer;
	}

	@PostMapping("/proxy")
	public boolean getMessage(HttpServletRequest request) {
		System.out.println(tracer.activeSpan());
		HttpStatus statusCode = restTemplate
				.postForEntity(
						format("%s/message", request.getRequestURL().toString().replace(request.getRequestURI(), "")), "hello", String.class, Map.of()
				)
				.getStatusCode();
		return statusCode.is2xxSuccessful();
	}

	@GetMapping("/errorPath")
	public String throwError() {
		return demoService.test();
	}
}