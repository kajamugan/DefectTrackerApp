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

import com.kaja.DefectTracker.entities.Modules;
import com.kaja.DefectTracker.repository.ModuleRepository;

@RestController
@RequestMapping("api/v1")
public class ModelController {
	@Autowired
	ModuleRepository moduleRepository;

	@PostMapping("/module")
	public ResponseEntity<?> createNote(@RequestBody Modules module) {
		moduleRepository.save(module);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/module")
	public List<Modules> getModule() {
		return moduleRepository.findAll();

	}

	@PutMapping("/module/{id}")
	public ResponseEntity<Object> updateModule(@RequestBody Modules module, @PathVariable long id) {

		Optional<Modules> employeeOptional = moduleRepository.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		module.setId(id);

		moduleRepository.save(module);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/module/{id}")
	public void deleteModule(@PathVariable long id) {
		moduleRepository.deleteById(id);
	}
}
