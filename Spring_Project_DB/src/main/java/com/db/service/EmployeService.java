package com.db.service;

import java.util.List;

import com.db.model.Employee;

public interface EmployeService {
	public Employee saveEmployee(Employee emp);
	public Employee getEmployeeById(Integer id);
	public boolean deletEmployeeById(Integer id);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployeeByNameAndId(Integer id, String name);
	public boolean updateEmployee(Employee emp);


}
