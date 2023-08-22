package com.db.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Employee;
import com.db.service.EmployeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EmployeeControler {
	
	@Autowired
	public EmployeService emService;
	
	@PostMapping("/saveEmp")
	public Employee addEmployee(@RequestBody Employee emp) {
		log.info("saveEmp Api called");
		return emService.saveEmployee(emp);
	}
	
	@GetMapping(path = "/getEmp/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		log.info("This is Id: " + id);
		return emService.getEmployeeById(id);
	}
	
	@DeleteMapping("/deletEmp/{id}")
	public void deletEmployeeById(@PathVariable Integer id) {
		emService.deletEmployeeById(id);
	}
}
