package com.kaja.DefectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaja.DefectTracker.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
