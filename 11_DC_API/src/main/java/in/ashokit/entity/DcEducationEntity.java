package in.ashokit.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_EDUCATION")
public class DcEducationEntity {

	
	@Id
	@GeneratedValue
	private Integer eduId;
	private Long caseNumber;
	private String higestQualification;
	private String graduationYear;
	
	
	
}
