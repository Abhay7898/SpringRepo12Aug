package com.db.serviceimpl;

import java.util.List;

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
		Employee emp = emRepo.getById(id);
		log.info(emp.toString());
		return emp;
	}
	
	@Override
	public boolean deletEmployeeById(Integer id) {
		try {
			emRepo.deleteById(id);
		}catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return emRepo.findByFirstName(name);
	}

	@Override
	public List<Employee> getEmployeeByNameAndId(Integer id, String name) {
		return emRepo.findByIdAndFirstName(id, name);
	}



}
