package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.Income;
import in.ashokit.service.DcService;

@RestController
public class IncomeRestController {

	
	
	@Autowired
	private DcService dcService;
	
	
	
	@PostMapping("/saveIncome")
	public ResponseEntity<Long>  saveIncomeDetails(@RequestBody Income income)
	{
		
		Long caseNumber = dcService.saveIncomeData(income);
		return new ResponseEntity<Long>(caseNumber,HttpStatus.CREATED);
		
	}
	
	
}
