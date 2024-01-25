package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Education;
import in.ashokit.service.DcService;

@RestController
public class EducationRestController {

	
	
	@Autowired
	private DcService dcService;
	
	@PostMapping("/saveEduactionDetails")
	public ResponseEntity<Long> saveEducationDetails(@RequestBody Education education)
	{
		Long caseNumber = dcService.saveEducationData(education);
		return new ResponseEntity<Long>(caseNumber,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
