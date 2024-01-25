package in.ashokit.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CASES")
public class DcCaseEntity {

	
	@Id
	@GeneratedValue
	private Long caseNumber;
	private Integer appId;
	private Integer planId;
	
	
	
	
}
