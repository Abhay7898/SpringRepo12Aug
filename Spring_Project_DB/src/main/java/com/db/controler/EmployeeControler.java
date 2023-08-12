package com.db.controler;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	

}
