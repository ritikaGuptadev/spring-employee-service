package com.TestingAppApplication.TestingAppApplication.repositories;

import com.TestingAppApplication.TestingAppApplication.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmail(String email);
}
