package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.EmployeeRepositary.EmployeeRepositary;
import com.app.model.Employee;
import com.app.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepositary er;
	@Override
	public boolean saveEmployee(Employee e) {
		Employee em=er.save(e);
		if(em!=null) {
		return true;}
		else {
			return false;
		}
	}
	@Override
	public List<Employee> getallemp() {
		List<Employee> list=er.findAll();
		return list;
	}
	@Override
	public Optional<Employee> getallemp(int id) {
		Optional<Employee> op= er.findById(id);
		return op;
	}
	@Override
	public boolean deleteEmployee(int id) {
		er.deleteById(id);
		if(er.existsById(id)) {
			return false;
		}
		else {
			return true;
		}
		 
	}

	
}
