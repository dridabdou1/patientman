package com.patientman.patientman.mapper;

import java.time.LocalDate;
import java.util.UUID;

import com.patientman.patientman.dto.PatientCreateDTO;
import com.patientman.patientman.models.Patient;

public class PatientCreateDTOMapper {
    // map to Patient
    public static Patient mapToPatient(PatientCreateDTO dto) {
        return new Patient(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getAddress(),
                LocalDate.parse(dto.getDateOfBirth()),
                LocalDate.now());
    }   

    public static PatientCreateDTO mapToPatientResponseDTO(Patient patient) {
        return new PatientCreateDTO(                
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().toString());
    }
}
