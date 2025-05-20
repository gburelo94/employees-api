package com.twobrains.employees_api.controllers;

import com.twobrains.employees_api.model.dto.EmployeeRequest;
import com.twobrains.employees_api.services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employees")
@RequiredArgsConstructor
@Tag(name = "Employees", description = "Employee management API")
public class EmployeeController {

    private final EmployeeService service;

    @Operation(
            summary = "Obtener todos los empleados",
            description = "Retorna una lista con todos los empleados")
    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @GetMapping
    public ResponseEntity<?> getEmployees() {
        return ResponseEntity.ok(service.getEmployees());
    }

    @Operation(
            summary = "Eliminar empleado por id",
            description = "Se elimina a un empleado por su id")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Eliminación exitosa"),
            @ApiResponse(responseCode = "404", description = "Empleado no enconrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Actualizar empleado",
            description = "Actualiza un empleado por su id")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Operation(
            summary = "Crea uno o mas empleados",
            description = "Crea multiples empleados en una sola petición")
    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody List<EmployeeRequest> requests) {
        return new ResponseEntity<>(service.save(requests), HttpStatus.CREATED);
    }
}
