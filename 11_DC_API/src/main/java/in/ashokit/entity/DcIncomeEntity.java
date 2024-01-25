package in.ashokit.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_INCOME")
public class DcIncomeEntity {

	@Id
	@GeneratedValue
	 private Integer incomeId;
	 private Long caseNumber;
	 private Double empIncome;
	 private Double propertyIncome;
	 
	
	
	
}
