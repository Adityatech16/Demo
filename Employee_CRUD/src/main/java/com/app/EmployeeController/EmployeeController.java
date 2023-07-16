package com.app.EmployeeController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("Emp")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@PostMapping("/saveemployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee e){
		System.out.println(e);

		boolean flag=es.saveEmployee(e);
		if(flag) {
			return new  ResponseEntity<String>("Employee information saved successfuly", HttpStatus.CREATED); 
		}
		else {
			return new  ResponseEntity<String>("Employee information Not Saved!", HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> elist= es.getallemp();
		
		return new ResponseEntity<List<Employee>> (elist,HttpStatus.OK);
		
	}
	
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		Optional<Employee> elist= es.getallemp(id);
		if(elist.isPresent()) {
			Employee em=	elist.get();
		return new ResponseEntity<Employee> (em,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e,@PathVariable int id){
		Optional<Employee> elist= es.getallemp(id);
		if(elist.isPresent()) {
			es.saveEmployee(e);
		return new ResponseEntity<Employee> (e,HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Employee> (HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		Optional<Employee> elist= es.getallemp(id);
		if(elist.isPresent()) {
			boolean flag=es.deleteEmployee(id);
		return new ResponseEntity<String> ("Employee Deleted Successfully!"+flag,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String> (HttpStatus.NOT_FOUND);
		}
	}
	

}
