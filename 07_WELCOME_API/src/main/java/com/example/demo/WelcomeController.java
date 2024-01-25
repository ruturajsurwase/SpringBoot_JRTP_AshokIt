package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController 
{

	@Autowired
	private GreetClient greetClient;
	
	@GetMapping("/welcome")
	public String welcomemsg()
	{
		String msg="welcome to cjc";
		
		String greetmsg = greetClient.invokeGreetApi();
		
		return msg+""+greetmsg;
	}
}
