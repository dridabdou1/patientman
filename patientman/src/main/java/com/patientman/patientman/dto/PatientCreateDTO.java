package com.patientman.patientman.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreateDTO {
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;
}

