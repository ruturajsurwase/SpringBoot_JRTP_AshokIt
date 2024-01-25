package in.ashokit.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.CreatCaseResponse;
import in.ashokit.service.DcService;

@RestController
public class CreateCaseController
{

	
	@Autowired
	private DcService dcService;

	@GetMapping("/case/{appId}")
	public ResponseEntity<CreatCaseResponse> createCase(@PathVariable Integer appId)
	{
		Long caseNumber = dcService.loadCaseNumber(appId);
		Map<Integer, String> planNames = dcService.getPlanNames();
		CreatCaseResponse response=new CreatCaseResponse();
		 		response.setCaseNumber(caseNumber);
		 		response.setPlanNames(planNames);
		 return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
