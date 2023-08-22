package com.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.model.Employee;

@Repository
public interface EmployeeRepositryInterface extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByFirstName(String name);

	List<Employee> findByIdAndFirstName(Integer id,String name);
	
}
