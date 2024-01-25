package com.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController 
{
	Logger logger=LoggerFactory.getLogger(GreetController.class);
	
	@GetMapping("/greet")
	public String greetMsg()
	{
		 logger.info("getGreetMSg() execution started");
		String msg="Good Evening.......!";
		 logger.info("getGreetMSg() execution ended");
		return msg;
		
	}
	
	
}
