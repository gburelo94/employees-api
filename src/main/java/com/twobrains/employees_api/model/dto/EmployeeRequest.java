package com.twobrains.employees_api.model.dto;

import com.twobrains.employees_api.model.entities.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmployeeRequest {

    @NotBlank(message = "El nombre es requerido")
    @Schema(description = "Nombre", example = "Juan")
    private String name;

    @Schema(description = "Segundo nombre", example = "Carlos")
    private String middleName;

    @NotBlank(message = "El apellido paterno es requerido")
    @Schema(description = "Apellido paterno", example = "Pérez")
    private String lastName;

    @Schema(description = "Apellido materno", example = "López")
    private String secondLastName;

    @Min(value = 1, message = "El valor minimo para la edad es 1")
    @Schema(description = "Edad del empleado", example = "30")
    private Integer age;

    @Schema(description = "Sexo del empleado", example = "MALE")
    private Gender gender;

    @Past
    @Schema(description = "Fecha de nacimiento", example = "1990-05-20")
    private LocalDate birthDate;

    @Schema(description = "Puesto del empleado", example = "Analista de datos")
    private String position;
}
