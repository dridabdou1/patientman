package com.patientman.patientman.mapper;

import java.time.LocalDate;

import com.patientman.patientman.dto.PatientUpdateDTO;
import com.patientman.patientman.models.Patient;

public class PatientUpdateDTOMapper {
    // map Patient to PatientUpdateDTO
    public static void mapToPatientUpdateDTO(Patient patient, PatientUpdateDTO dto) {
        if (dto.getName() != null) {
            patient.setName(dto.getName());
        }
        
        if (dto.getAddress() != null) {
            patient.setName(dto.getAddress());
        }
        
        if(dto.getEmail() != null){
            patient.setEmail(dto.getEmail());        
        }

        if (dto.getDateOfBirth()!=null) {
            patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        }                
    }

    public static void mapToPatient(PatientUpdateDTO dto, Patient patient) {
        patient.setName(dto.getName());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
    }
}
