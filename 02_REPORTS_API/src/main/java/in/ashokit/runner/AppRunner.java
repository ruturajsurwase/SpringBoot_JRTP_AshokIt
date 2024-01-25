package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Component;

import in.ashokit.entity.EligibilityDetails;
import in.ashokit.repo.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityDetailsRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibilityDetails entity1 = new EligibilityDetails();
		entity1.setEligId(1);
		entity1.setName("ruturaj");
		entity1.setMobile(123456);
		entity1.setGender('M');
		entity1.setSsn(675765999);
		entity1.setPlanName("SNAP");
		entity1.setPlanStatus("Approved");

		repo.save(entity1);

		EligibilityDetails entity2 = new EligibilityDetails();
		entity2.setEligId(2);
		entity2.setName("raj");
		entity2.setMobile(32123456);
		entity2.setGender('M');
		entity2.setSsn(675765999);
		entity2.setPlanName("CCAP");
		entity2.setPlanStatus("Denied");
		repo.save(entity2);
		
		
		EligibilityDetails entity3 = new EligibilityDetails();
		entity3.setEligId(3);
		entity3.setName("hitesh");
		entity3.setMobile(32123456);
		entity3.setGender('M');
		entity3.setSsn(675765999);
		entity3.setPlanName("Medicaid");
		entity3.setPlanStatus("Approved");
		repo.save(entity3);
		
		
		
	}

}
