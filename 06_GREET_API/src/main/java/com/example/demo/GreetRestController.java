package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@GetMapping("/greet")
	public String grettingMsg()
	{	
		String msg="Good nights";
		
		return msg;
	  
	}
}
