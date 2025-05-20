package com.twobrains.employees_api.repositories;

import com.twobrains.employees_api.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
