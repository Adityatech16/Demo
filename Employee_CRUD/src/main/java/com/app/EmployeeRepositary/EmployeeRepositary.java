package com.app.EmployeeRepositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;
@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Integer>{

	
}
