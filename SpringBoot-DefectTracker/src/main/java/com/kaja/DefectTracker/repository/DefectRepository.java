package com.kaja.DefectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaja.DefectTracker.entities.Defect;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {
	// Defect findDefectById(Long id);
}
