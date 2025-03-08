package app.com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.com.example.model.Employee;
import app.com.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
		
	}
	
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
		
	}
	
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id)
	{
		return employeeService.getEmployeeById(id);
	}
	
	
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable Long id)
	{
		employeeService.deleteEmployeeById(id);
		return "Employee "+id+" Deleted SuccesFully" ;	
	}
	@DeleteMapping
	public String deleteEmployees()
	{
		employeeService.deleteAllEmployees();
		return "All Employees Deleted SuccesFully" ;	
	}
	
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		employeeService.updateEmployee(id,employee);
		return "Employee "+id+" Updated SuccesFully";
	}
	

	
	@GetMapping("/average-salary")
	public double getTotalAverageSalary()
	{
		return employeeService.getTotalAverageSalary();
	}
	
	@GetMapping("/average-salary/{department}")
	public double getAverageSalaryByDepartment(@PathVariable String department)
	{
		return employeeService.getAverageSalaryByDepartment(department);
	}
	
	@GetMapping("department/{department}")
	public List<Employee> getEmployeeByDepartment(@PathVariable String department)
	{
		return employeeService.getEmployeeByDepartment(department);
	}
	
	
	

}
