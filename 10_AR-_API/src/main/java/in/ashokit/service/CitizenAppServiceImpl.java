package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.bindings.CitizenApp;
import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.repo.CitizenAppRepo;

public class CitizenAppServiceImpl implements CitizenAppService {

	@Autowired
	private CitizenAppRepo citizenAppRepo;

	@Override
	public Integer creatApplication(CitizenApp app) 
	{
		// make rest call to ssa web api with ssnnumber as input

		String endpoinrurl = "";

//		RestTemplate rt = new RestTemplate();
//
//		ResponseEntity<String> restEntity = rt.getForEntity(endpoinrurl, String.class, app.getSsn());
//
//		String stateName = restEntity.getBody();

		
		
		WebClient webClient = WebClient.create();
		
		String stateName = webClient.get()   //it represents get request
									.uri(endpoinrurl, app.getSsn())   //it represents URL to sedn req
									.retrieve()       //to retrieve response
									.bodyToMono(String.class)  //to specify response type 
									.block();   // to make synchronous call
		
		
		
		
		if ("New Jersey".equals(stateName)) 
		{
			// creat application
			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(app, entity);
		
			entity.setStateName(stateName);
			
			
			CitizenAppEntity save = citizenAppRepo.save(entity);
			return save.getAppId();
		}
		return 0;
	}

}
