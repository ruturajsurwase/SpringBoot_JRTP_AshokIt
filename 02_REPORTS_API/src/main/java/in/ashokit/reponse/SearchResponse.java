package in.ashokit.reponse;

import lombok.Data;

@Data
public class SearchResponse {

	private String name;
	private long mobile;
	private String email;
	private Character gender;
	private long ssn;

}
