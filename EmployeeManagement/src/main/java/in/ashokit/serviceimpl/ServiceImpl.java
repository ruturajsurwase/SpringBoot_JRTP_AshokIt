package in.ashokit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repository.EmployeeRepository;

@Service
public class ServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public boolean saveEmp(Employee e) 
	{
		Employee isSaved = employeeRepository.save(e);
		
		return isSaved.getId() !=null;
	}

	@Override
	public List<Employee> getAllEmployee() 
	{
		List<Employee> elist = employeeRepository.findAll();		
		return elist;
	}

	
	@Override
	public Employee getEmployeeById(Integer id) 
	{
		Optional<Employee> findById = employeeRepository.findById(id);
		
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean daleteEmployee(Integer id)
	{
		boolean status = false;
		try 
		{
			employeeRepository.deleteById(id);	
			status = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
		
		
	}

	@Override
	public boolean updateEmployee(Employee e) 
	{
		Employee isSaved = employeeRepository.save(e);
		return isSaved.getId() !=null;
	}

}
