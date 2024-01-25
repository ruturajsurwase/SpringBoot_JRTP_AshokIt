package in.ashokit.service;


import java.util.Map;

import in.ashokit.bindings.ChildRequest;
import in.ashokit.bindings.DcSummary;
import in.ashokit.bindings.Education;
import in.ashokit.bindings.Income;
import in.ashokit.bindings.PlanSelection;

public interface DcService 
{
		public Long loadCaseNumber(Integer appId);
		
		public Map<Integer,String> getPlanNames();
		
		public Long savePlanSelection(PlanSelection planSelection);
	
		public Long saveIncomeData(Income income);
		
		public Long saveEducationData(Education education);
		
		public Long saveChildrensData(ChildRequest request);
  	
		public DcSummary getSummary(Long caseNumber);
}	
