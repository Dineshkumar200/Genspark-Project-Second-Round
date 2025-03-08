package app.com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.com.example.model.Employee;
import app.com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		
		return  employeeRepository.save(employee);
	}

	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
		
	}

	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}


	public Optional<Employee> getEmployeeById(Long id) {
		
		return employeeRepository.findById(id);
	}

	public void updateEmployee(Long id,Employee employeeDetails) {
		Optional<Employee> employeeOptional=employeeRepository.findById(id);
		Employee employee=employeeOptional.orElseThrow(() -> new RuntimeException("Employee not found"));
		if(employee!=null)
		{
			
			employee.setName(employeeDetails.getName());
			employee.setAge(employeeDetails.getAge());
			
			employee.setDepartment(employeeDetails.getDepartment());
			employee.setSalary(employeeDetails.getSalary());
			
			employeeRepository.save(employee);
		}
		
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
		
	}
	public double getAverageSalaryByDepartment(String department)
	{
		return employeeRepository.getAverageSalaryByDepartment(department);
		
	}
	
	public double getTotalAverageSalary()
	{
		return employeeRepository.getTotalAverageSalary();
	}
	
	public List<Employee> getEmployeeByDepartment(String department)
	{
		return employeeRepository.findByDepartment(department);
	}

}
