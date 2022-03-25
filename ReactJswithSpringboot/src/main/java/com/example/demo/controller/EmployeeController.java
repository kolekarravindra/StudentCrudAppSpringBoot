package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResouceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRespository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRespository employerep;
	
	// get employee
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		
		return employerep.findAll();
	}
	
	// create employee
	@PostMapping("/employees")
    public Employee createEmployee(@RequestBody  Employee empl) {
	
	  return employerep.save(empl);	
}
	//get employee by id
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
	
		Employee empl = employerep.findById(id).orElseThrow(() -> 
		new ResouceNotFoundException("Employee not exits with id :"+id));
		return ResponseEntity.ok(empl);
	}
	
	//update rest employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
		Employee empl = employerep.findById(id).orElseThrow(() -> 
		new ResouceNotFoundException("Employee not exits with id :"+id));
		
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		empl.setEmaialId(employee.getEmaialId());
		
		Employee updateemployee =employerep.save(empl);
		return ResponseEntity.ok(updateemployee);
		
		
	}
	
	
	//delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee empl = employerep.findById(id).orElseThrow(() -> 
		new ResouceNotFoundException("Employee not exits with id :"+id));
		
		employerep.delete(empl);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
