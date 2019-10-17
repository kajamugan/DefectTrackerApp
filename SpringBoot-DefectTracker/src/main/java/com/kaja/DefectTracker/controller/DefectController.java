package com.kaja.DefectTracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaja.DefectTracker.entities.Defect;
import com.kaja.DefectTracker.repository.DefectRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class DefectController {
	@Autowired
	DefectRepository defectRepository;

	@PostMapping("/defect")
	public ResponseEntity<?> createNote(@RequestBody Defect defect) {
		defectRepository.save(defect);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/defect")
	public List<Defect> getDefect() {
		return defectRepository.findAll();

	}

	@PutMapping("/defect/{id}")
	public ResponseEntity<Object> updateDefect(@RequestBody Defect defect, @PathVariable long id) {

		Optional<Defect> defectOptional = defectRepository.findById(id);

		if (!defectOptional.isPresent())
			return ResponseEntity.notFound().build();

		defect.setId(id);

		defectRepository.save(defect);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/defect/{id}")
	public void deleteProject(@PathVariable long id) {
		defectRepository.deleteById(id);
	}

}
