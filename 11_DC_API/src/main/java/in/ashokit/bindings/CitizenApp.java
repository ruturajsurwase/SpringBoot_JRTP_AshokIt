package in.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	private String email;
	private Long phnNo;
	private String gender;
	private Long ssn; 
	private String stateName;
	private LocalDate dob;
}
