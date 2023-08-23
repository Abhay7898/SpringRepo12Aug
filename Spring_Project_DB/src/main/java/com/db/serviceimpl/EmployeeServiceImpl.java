package com.db.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.model.Employee;
import com.db.repo.EmployeeRepositryInterface;
import com.db.service.EmployeService;
import com.db.utils.Utility;

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
		Employee emp = null;
		try {
			emp = emRepo.getReferenceById(id);
			log.info(emp.toString());
		} catch (Exception e) {
			log.error("Data Not found");
			emp = null;
		}
		return emp;
	}

	@Override
	public boolean deletEmployeeById(Integer id) {
		try {
			emRepo.deleteById(id);
		} catch (Exception e) {
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

	@Override
	public boolean updateEmployee(Employee emp) {

		Optional<Employee> em = emRepo.findById(emp.getId());

		if (em.isPresent()) {

			Employee oldEm = em.get();

			oldEm.setAddress(emp.getAddress());
			oldEm.setAge(emp.getAge());
			oldEm.setFirstName(emp.getFirstName());

			try {
				emRepo.save(oldEm);
				log.info(Utility.DATA_UPDATE_SUCCEFULLY);
				return true;
			} catch (Exception e) {
				log.error(Utility.DATA_UPDATION_FAILED);
				return false;
			}
		} else {
			return false;
		}
	}

}
