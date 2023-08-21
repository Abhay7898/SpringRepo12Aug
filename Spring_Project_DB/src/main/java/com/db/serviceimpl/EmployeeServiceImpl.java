package com.db.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.model.Employee;
import com.db.repo.EmployeeRepositryInterface;
import com.db.service.EmployeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeService {

	@Autowired
	public EmployeeRepositryInterface emRepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee emplog = emRepo.save(emp);
		log.info(emp.toString());
		return emplog;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp = emRepo.getReferenceById(id);
		log.info(emp.toString());
		return emp;
	}

}
