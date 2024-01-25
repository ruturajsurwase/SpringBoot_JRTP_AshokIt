package in.ashokit.bindings;

import java.util.Map;

import lombok.Data;

@Data
public class CreatCaseResponse {

	private Long caseNumber;
	private  Map<Integer,String> planNames;
	
	
}
