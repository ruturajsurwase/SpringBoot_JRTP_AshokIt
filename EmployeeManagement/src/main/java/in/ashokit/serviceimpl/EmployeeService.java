package in.ashokit.serviceimpl;

import java.util.List;

import in.ashokit.entity.Employee;

public interface EmployeeService
{

	public boolean saveEmp(Employee e);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Integer id);
	
	public boolean daleteEmployee(Integer id);
	
	public boolean updateEmployee(Employee e);
	
	
	
	
	
}
