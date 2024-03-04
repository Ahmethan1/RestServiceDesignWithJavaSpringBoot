package com.ahmethan.project.repository;

import com.ahmethan.project.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Integer> {
    boolean existsByEmail(String email);
}

