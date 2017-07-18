package com.training.sample.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping("/world")
	public String helloWorld(String input){
		return "Hello World";
	}
}
