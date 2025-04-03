package com.patientman.patientman.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreateDTO {
    @NotBlank(message="Name is Required")    
    @Size(max = 100, message =  "Name can't exceed 100 characters")
    private String name;
    @Email(message= "Invalid Email")
    @NotBlank(message="Email is Required")
    private String email;
    @NotBlank(message="Address is Required")
    private String address;    
    @NotBlank(message="Date of Birth is Required")
    private String dateOfBirth;
}

