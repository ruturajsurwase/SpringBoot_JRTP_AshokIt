package in.ashokit.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import in.ashokit.entity.Employee;
import in.ashokit.serviceimpl.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest 
{
	
	@InjectMocks
    private EmployeeRestController employeeRestController;

    @Mock
    private EmployeeService employeeService;
    
    
    @Test
    public void testSaveEmployee_Success() 
    {
        // Create a mock Employee object
        Employee mockEmployee = new Employee();
        // Define the behavior of the mock service
        when(employeeService.saveEmp(any(Employee.class))).thenReturn(true);

        ResponseEntity<String> response = employeeRestController.saveEmployee(mockEmployee);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("employee saved", response.getBody());
    }

    @Test
    public void testSaveEmployee_Failure() {
        Employee mockEmployee = new Employee();
        when(employeeService.saveEmp(any(Employee.class))).thenReturn(false);

        ResponseEntity<String> response = employeeRestController.saveEmployee(mockEmployee);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("employee not saved", response.getBody());
    }

    // Similarly, write test methods for other controller methods

}
