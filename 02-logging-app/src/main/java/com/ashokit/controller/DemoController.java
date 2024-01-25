package com.ashokit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	
	Logger logger=LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/welcome")
	public String getWelcomeMSg()
	{
		 logger.info("getWelcomeMSg() execution started");
		 
		 String msg= "Welcome to Ashok IT";
		 try
		 {
			int i=10/0; 
		 }
		 catch(Exception e)
		 {
			 logger.info("exception occured" +e.getLocalizedMessage());
		 }
		 		
		 logger.info("getWelcomeMSg() execution ended");
		
		return msg;
	}
}
