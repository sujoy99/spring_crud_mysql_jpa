package org.itbl.crud.service;

import java.util.List;

import org.itbl.crud.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
}
