package in.ashokit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.Child;
import in.ashokit.bindings.ChildRequest;
import in.ashokit.bindings.DcSummary;
import in.ashokit.bindings.Education;
import in.ashokit.bindings.Income;
import in.ashokit.bindings.PlanSelection;
import in.ashokit.entity.CitizenAppEntity;
import in.ashokit.entity.DcCaseEntity;

import in.ashokit.entity.DcChildrenEntity;

import in.ashokit.entity.DcEducationEntity;
import in.ashokit.entity.DcIncomeEntity;
import in.ashokit.entity.PlanEntity;
import in.ashokit.repo.CitizenAppRepo;
import in.ashokit.repo.DcCaseRepo;
import in.ashokit.repo.DcChildrenRepo;
import in.ashokit.repo.DcEducationRepo;
import in.ashokit.repo.DcIncomeRepo;
import in.ashokit.repo.PlanRepository;

@Service
public class DcServiceImpl implements DcService 
{
	@Autowired
	private DcCaseRepo dcCaseRepo;
	
	@Autowired
	private PlanRepository planRepository;
	
	@Autowired
	private DcIncomeRepo dcIncomeRepo; 
	
	@Autowired
	private DcEducationRepo dcEducationRepo;
	
	@Autowired
	private DcChildrenRepo dcChildrenRepo;
	
    @Autowired
   private PlanRepository planRepo;
    
    @Autowired
    private CitizenAppRepo citizenAppRepo;
	
	
	@Override
	public Long loadCaseNumber(Integer appId) 
	{
		
		Optional<CitizenAppEntity> app = citizenAppRepo.findById(appId);
		if(app.isPresent())
		{
			DcCaseEntity entity=new DcCaseEntity();
			entity.setAppId(appId);
			DcCaseEntity savedEntity = dcCaseRepo.save(entity);
			return savedEntity.getCaseNumber();
		}
       return 0L;
     }

	@Override
	public  Map<Integer,String>getPlanNames() 
	{
		List<PlanEntity> findAll = planRepository.findAll();
		
		 Map<Integer,String> plansMap=new HashMap<>();
		 
		for(PlanEntity entity:findAll)
		{
			plansMap.put(entity.getPlanId(),entity.getPlanName());
			
		}
		return plansMap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection)
	{
		
		Optional<DcCaseEntity> findById = dcCaseRepo.findById(planSelection.getCaseNumber());
		
		if(findById.isPresent())
		{
			DcCaseEntity dcCaseEntity = findById.get();
			dcCaseEntity.setPlanId(planSelection.getPlanId());
			dcCaseRepo.save(dcCaseEntity);	
			return planSelection.getCaseNumber();
		}
		return null;
		
	}

	@Override
	public Long saveIncomeData(Income income) 
	{
		DcIncomeEntity entity = new DcIncomeEntity();

		BeanUtils.copyProperties(income, entity);

		DcIncomeEntity save = dcIncomeRepo.save(entity);

		return save.getCaseNumber();
	}

	@Override
	public Long saveEducationData(Education education) 
	{

		DcEducationEntity entity=new DcEducationEntity();
		 
		BeanUtils.copyProperties(education, entity);
		
		DcEducationEntity save = dcEducationRepo.save(entity);
		
		return save.getCaseNumber();
	}

	@Override
	public Long saveChildrensData(ChildRequest request)
	{
	
		List<Child> childs = request.getChilds();
		
		for( Child c :childs)
		{	DcChildrenEntity entity=new DcChildrenEntity();
			BeanUtils.copyProperties(c,entity);
			dcChildrenRepo.save(entity);
		}
		//dcChildrenRepo.saveAll(entity);
		return request.getCaseNumber();
		
		
	}


	@Override
	public DcSummary getSummary(Long caseNumber)
	{
		String planName="";
		
		DcIncomeEntity IncomeEntity = dcIncomeRepo.findByCaseNumber(caseNumber);
		DcEducationEntity educationEntity = dcEducationRepo.findByCaseNumber(caseNumber);
		List<DcChildrenEntity> childrensEntity = dcChildrenRepo.findByCaseNumber(caseNumber);
		
		Optional<DcCaseEntity> dcCase= dcCaseRepo.findById(caseNumber);
		   if(dcCase.isPresent())
		   {
			     Integer planId = dcCase.get().getPlanId();
			     Optional<PlanEntity> plan = planRepo.findById(planId);
			     
			     if(plan.isPresent())
			     {
			    	   planName= plan.get().getPlanName();
			     }
		   }
		   
		   
		   //set data to summery object
		   
		     DcSummary dcSummary = new DcSummary();
		     dcSummary.setPlanName(planName);
		    
		     Income income = new Income();
		     BeanUtils.copyProperties(IncomeEntity, income);
		     dcSummary.setIncome(income);
		     
		     Education education=new Education();
		     BeanUtils.copyProperties(educationEntity, education);
		     dcSummary.setEducation(education);
		     
		     
		     List<Child> childs=new ArrayList<>();
		     for(DcChildrenEntity entity:childrensEntity)
		     {
		    	 Child ch=new Child();
		    	  BeanUtils.copyProperties(entity, ch);
		    	 childs.add(ch);
		     }
		     dcSummary.setChild(childs);
		     
		return dcSummary;
	}

}
