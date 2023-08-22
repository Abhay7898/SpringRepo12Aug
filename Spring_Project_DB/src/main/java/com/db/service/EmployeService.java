package com.db.service;

import com.db.model.Employee;

public interface EmployeService {
	public Employee saveEmployee(Employee emp);
	public Employee getEmployeeById(Integer id);
	public void deletEmployeeById(Integer id);
}
