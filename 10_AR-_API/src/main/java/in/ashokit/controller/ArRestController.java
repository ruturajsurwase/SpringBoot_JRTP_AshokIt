package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.CitizenApp;

import in.ashokit.service.CitizenAppService;

@RestController
public class ArRestController 
{

	@Autowired
	CitizenAppService citizenAppService;
	
	@PostMapping("creatapplicstion")
	public ResponseEntity<String> creatApplication(@RequestBody CitizenApp app)
	{
		Integer appId = citizenAppService.creatApplication(app); 
		
		if(appId>0)
		{
        return new ResponseEntity<>("application created with id" +appId,HttpStatus.OK);			
		}
		else
		{
			   return new ResponseEntity<>("invalid ssn",HttpStatus.BAD_REQUEST);	
		}
	}
	
	
}
