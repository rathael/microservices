package com.adex.microservices.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.adex.microservices.models.Greeting;

public class MainController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestPart(value="name") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
