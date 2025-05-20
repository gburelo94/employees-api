package com.twobrains.employees_api.services;

import com.twobrains.employees_api.model.dto.EmployeeRequest;
import com.twobrains.employees_api.model.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> getEmployees();

    List<EmployeeResponse> save(List<EmployeeRequest> request);

    EmployeeResponse update(Long id, EmployeeRequest request);

    void delete(Long id);
}
