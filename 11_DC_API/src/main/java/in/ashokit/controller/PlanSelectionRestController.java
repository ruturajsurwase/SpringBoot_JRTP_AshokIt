package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.PlanSelection;
import in.ashokit.service.DcService;

@RestController
public class PlanSelectionRestController {

	@Autowired
	private DcService dcService;
	
	
	@PostMapping("/planSelection")
	public ResponseEntity<Long> savePlanSelection(@RequestBody PlanSelection  planSelection)
	{
		
		Long caseNumber = dcService.savePlanSelection(planSelection);
		
		return new ResponseEntity<Long>(caseNumber,HttpStatus.CREATED);
		
	}
	
		
}
