package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Employee;
import in.ashokit.serviceimpl.EmployeeService;


@RestController
public class EmployeeRestController 
{
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee e)
	{
		boolean isSaveEmp = employeeService.saveEmp(e);
		
		if(isSaveEmp)
		{
			return new ResponseEntity<String>("employee saved",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>("employee not saved",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> allEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/getemp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Integer id)
	{ 
		Employee employeeById = employeeService.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer id)
	{
		boolean daleteEmployee = employeeService.daleteEmployee(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
  @PutMapping("/update")
  public ResponseEntity<String> updateEmp(@RequestBody Employee emp)
	{
	  boolean updateEmployee = employeeService.updateEmployee(emp);
	  return new ResponseEntity<String>("updated",HttpStatus.CREATED);
	}
	
	
}
