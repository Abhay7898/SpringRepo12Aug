package com.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.model.Employee;

@Repository
public interface EmployeeRepositryInterface extends JpaRepository<Employee, Integer> {

}
