
package com.db.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Employee;
import com.db.service.EmployeService;
import com.db.utils.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/qa/")
public class EmployeeControler {

	@Value("${spring.datasource.url}")
	String serverName;

	@Autowired
	public EmployeService emService;

	@PostMapping("saveEmp")
	public Employee addEmployee(@RequestBody Employee emp) {

		log.info("saveEmp Api called");
		return emService.saveEmployee(emp);
	}

	@GetMapping(path = "getEmp/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		log.info("This is Id: " + id);

		if (serverName.equals("Dev")) {

			Employee e = emService.getEmployeeById(id);
			if (e == null) {
				return new ResponseEntity<>(Utility.USER_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(e, HttpStatus.FOUND);
			}
		} else if (serverName.equals("QA")) {
			log.info("QA setup");
			return new ResponseEntity<>("", HttpStatus.FOUND);
		}
		return new ResponseEntity<>("", HttpStatus.FOUND);

	}

	@GetMapping(path = "getEmpName/{name}")
	public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
		log.info("This is Name: " + name);
		List<Employee> list = emService.getEmployeeByName(name);
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<>(Utility.USER_ID_NOT_FOUND, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(list, HttpStatus.FOUND);
		}
	}

	@GetMapping(path = "getEmpByIdAndName")
	public List<Employee> getEmployeeByIdAndName(@Param("id") Integer id, @Param("name") String name) {
		log.info("This is Id: " + name);
		return emService.getEmployeeByNameAndId(id, name);
	}

	@DeleteMapping("deletEmp/{id}")
	public boolean deletEmployeeById(@PathVariable Integer id) {
		boolean b = emService.deletEmployeeById(id);
		if (!b) {
			return b;
		} else {
			Employee e = emService.getEmployeeById(id);
			if (e == null) {
				return true;
			} else {
				return false;
			}
		}
	}

	@PutMapping("updateEmp")
	public String updateEmployee(@RequestBody Employee emp) {
		log.info("updateEmp Api called");
		boolean flag = emService.updateEmployee(emp);

		if (flag) {
			return Utility.DATA_UPDATE_SUCCEFULLY;

		} else {
			return Utility.DATA_UPDATION_FAILED;

		}

	}

}
