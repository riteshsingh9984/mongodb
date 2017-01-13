package org.cmsapiservice;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.models.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public Long count();
	
	public List<Employee> getEmployees();
	
	public List<Employee> getEmployees(Sort sort);
	
	public Employee getEmployeeById(Long employeeId);
}
