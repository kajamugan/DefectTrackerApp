package com.kaja.DefectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaja.DefectTracker.entities.Modules;

@Repository
public interface ModuleRepository extends JpaRepository<Modules, Long> {
	// Project findByProjectId(Long id);
}
