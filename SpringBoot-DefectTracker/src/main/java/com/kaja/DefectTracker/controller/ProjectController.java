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

import com.kaja.DefectTracker.entities.Project;
import com.kaja.DefectTracker.repository.ProjectRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ProjectController {
	@Autowired
	ProjectRepository projectRepository;

	@PostMapping(value = "/project")
	public ResponseEntity<?> createNote(@RequestBody Project project) {
		projectRepository.save(project);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/project")
	public List<Project> getProject() {
		return projectRepository.findAll();

	}

	@PutMapping("/project/{id}")
	public ResponseEntity<Object> updateProject(@RequestBody Project project, @PathVariable long id) {

		Optional<Project> projectOptional = projectRepository.findById(id);

		if (!projectOptional.isPresent())
			return ResponseEntity.notFound().build();

		project.setId(id);

		projectRepository.save(project);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/project/{id}")
	public void deleteProject(@PathVariable long id) {
		projectRepository.deleteById(id);
	}

}
