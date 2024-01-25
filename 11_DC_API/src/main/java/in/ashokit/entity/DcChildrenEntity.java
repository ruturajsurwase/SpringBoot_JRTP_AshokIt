package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CHILDREN")
public class DcChildrenEntity
{

	
	@Id
	@GeneratedValue
	private Integer childId;
    private LocalDate childDob;
    private Long childSsn;
    private long caseNumber;
    
	
	
	
	
	
	
}
