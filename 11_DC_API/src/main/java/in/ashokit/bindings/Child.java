package in.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Child {
	private Integer childId;
	private String childName;
    private LocalDate childAge;
    private Long childSsn;
   
}
