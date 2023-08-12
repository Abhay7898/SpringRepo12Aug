package com.db.serviceimpl;

import org.springframework.stereotype.Service;

import com.db.model.Employee;
import com.db.service.EmployeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeService{

	@Override
	public Employee saveEmployee(Employee emp) {
		log.info(emp.toString());
		return null;
	}

}
