package com.kaja.DefectTracker.controller;

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

import com.kaja.DefectTracker.entities.Employee;
import com.kaja.DefectTracker.repository.EmployeeRepository;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/employee")
	public ResponseEntity<?> createNote(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();

	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

		Optional<Employee> employeeOptional = employeeRepository.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);

		employeeRepository.save(employee);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteById(id);
	}
}
