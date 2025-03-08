package app.com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.com.example.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	
	List<Employee> findByDepartment(String department);
	
	@Query("SELECT AVG(e.salary) FROM Employee e")
	Double getTotalAverageSalary();
	
	
	@Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department = :department")
    Double getAverageSalaryByDepartment(String department);
}
