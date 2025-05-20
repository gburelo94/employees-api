package com.twobrains.employees_api.services;

import com.twobrains.employees_api.exception.ApiException;
import com.twobrains.employees_api.model.dto.EmployeeRequest;
import com.twobrains.employees_api.model.dto.EmployeeResponse;
import com.twobrains.employees_api.model.entities.Employee;
import com.twobrains.employees_api.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public List<EmployeeResponse> getEmployees() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> save(List<EmployeeRequest> requests) {
        List<Employee> employees = requests.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());

        return repository.saveAll(employees).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee exists = repository.findById(id).orElseThrow(() ->
                new ApiException(
                        HttpStatus.NOT_FOUND,
                        "El empleado solicitado no existe."));
        updateEntity(exists, request);
        return toResponse(repository.save(exists));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new ApiException(
                    HttpStatus.NOT_FOUND,
                    "El empleado que intenta eliminar no existe.");
        }
    }

    private Employee toEntity(EmployeeRequest request) {
        return Employee
                .builder()
                .name(request.getName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .secondLastName(request.getSecondLastName())
                .age(request.getAge())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .build();
    }

    private EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .secondLastName(employee.getSecondLastName())
                .age(employee.getAge())
                .gender(employee.getGender())
                .birthDate(employee.getBirthDate())
                .position(employee.getPosition())
                .build();
    }

    private void updateEntity(Employee employee, EmployeeRequest request) {
        employee.setName(request.getName());
        employee.setMiddleName(request.getMiddleName());
        employee.setLastName(request.getLastName());
        employee.setSecondLastName(request.getSecondLastName());
        employee.setAge(request.getAge());
        employee.setGender(request.getGender());
        employee.setBirthDate(request.getBirthDate());
        employee.setPosition(request.getPosition());
    }
}
