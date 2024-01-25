package in.ashokit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.ashokit.bindings.ChildRequest;
import in.ashokit.bindings.DcSummary;
import in.ashokit.service.DcService;

@RestController
public class ChildrensRestController {

	
	@Autowired
	private DcService dcService;
	
	
	
	@PostMapping("/saveChildrens")
	public ResponseEntity<DcSummary> saveChildrensData(@RequestBody ChildRequest request)
	{
	   Long caseNumber = dcService.saveChildrensData(request);
		
		DcSummary summary = dcService.getSummary(caseNumber);
		
		return new  ResponseEntity<DcSummary>(summary,HttpStatus.OK);
	}
	
}
