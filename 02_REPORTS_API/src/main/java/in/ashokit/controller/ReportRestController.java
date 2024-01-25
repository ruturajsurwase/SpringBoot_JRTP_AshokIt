package in.ashokit.controller;

import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.reponse.SearchResponse;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportServiceImpl;

@RestController
public class ReportRestController {

	@Autowired
	private ReportServiceImpl service;
	
	    @GetMapping("/plans")
		public ResponseEntity<List<String>> getPlanNames()
		{
			List<String> uniquePlanNames = service.getUniquePlanNames();
			return new ResponseEntity<>(uniquePlanNames,HttpStatus.OK);
		}
	
	    @GetMapping("/status")
	    public ResponseEntity<List<String>> getPlanStatuses()
	    {
	    	List<String> uniquePlanStatus = service.getUniquePlanStatus();
	    	return new ResponseEntity<>(uniquePlanStatus,HttpStatus.OK);
	    }
	    
	    @PostMapping("/search")
	    public ResponseEntity<List<SearchResponse>> searchData(@RequestBody SearchRequest request)
	    {
	    	List<SearchResponse> searchResponse = service.search(request);
	    	return new ResponseEntity<>(searchResponse,HttpStatus.OK);
	    }
	    
	    
	    @GetMapping("/excel")
	    public void downloadExcel(HttpServletResponse response) throws Exception
	    {
	    	response.setContentType("application/octet-stream");
	    	String headerkey="Content-Disposition";
	    	String headerValue="attachment;filename=data.xls";
	    	response.setHeader(headerkey,headerValue);
	    	service.generateExcel(response);
	    }
	    
	    
	    @GetMapping("/pdf")
	    public void downloadPdf(HttpServletResponse response) throws  Exception
	    {
	    	response.setContentType("application/pdf");
	    	String headerkey="Content-Disposition";
	    	String headerValue="attachment;filename=data.pdf";
	    	response.setHeader(headerkey,headerValue);
	    	service.generatePdf(response);
	    }
	    
	    
	    
	    
	    
	    
}
