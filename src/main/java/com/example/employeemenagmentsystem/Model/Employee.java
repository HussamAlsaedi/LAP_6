package com.example.employeemenagmentsystem.Model;


import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    @NotNull(message = "id must not be empty")
    @Min(value = 2,message = "id must be at least 2 numbers long")
    private Integer id;

    @NotNull(message = "name must not be empty")
    @Size(min = 4, message = "name must be at least 4 characters long")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must contain only characters (no numbers).")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Must be a valid email format")
    private String email;

    @NotNull(message = "phoneNumber must not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and consist of 10 digits")
    private String phoneNumber;

    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be more than 18")
    @Max(value = 100, message = "Age must be less than 100")
    private Integer age;

    @NotNull(message = "position must not be empty")
    @Pattern(regexp = "^(supervisor|coordinator)$", message = "Position must be either 'supervisor' or 'coordinator'")
    @NotNull(message = "position must be not empty")
    private String position;

    @NotNull(message = "onLeave must be not empty")
    private boolean onLeave = false;

    @NotNull(message = "Hire date cannot be null")
    @PastOrPresent(message = "Hire date must be in the present or past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    @NotNull(message = "Annual leave cannot be null")
    @Positive(message = "Annual leave must be a positive number")
    private Integer annualLeave;

}
