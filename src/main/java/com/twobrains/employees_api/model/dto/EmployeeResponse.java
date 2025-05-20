package com.twobrains.employees_api.model.dto;

import com.twobrains.employees_api.model.entities.Gender;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class EmployeeResponse {

    private Long id;

    private String name;

    private String middleName;

    private String lastName;

    private String secondLastName;

    private Integer age;

    private Gender gender;

    private LocalDate birthDate;

    private String position;

}
