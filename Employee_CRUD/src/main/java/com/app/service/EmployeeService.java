package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Employee;

public interface EmployeeService {

	boolean saveEmployee(Employee e);

	List<Employee> getallemp();

	Optional<Employee> getallemp(int id);

	boolean deleteEmployee(int id);

}
