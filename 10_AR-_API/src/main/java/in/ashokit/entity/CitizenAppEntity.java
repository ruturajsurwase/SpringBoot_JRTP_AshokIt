package in.ashokit.entity;

import java.time.LocalDate;



import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_APP")
public class CitizenAppEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	private String fullName;
	private String email;
	private Long phnNo;
	private String gender;
	private Long ssn; 
	private String stateName;
	private LocalDate dob;
	
	@Column(name="CREATED_BY")	
    private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@CreationTimestamp
	private LocalDate 	createDate;
	
	
	@UpdateTimestamp
private LocalDate 	updateDate;
	
	
}
