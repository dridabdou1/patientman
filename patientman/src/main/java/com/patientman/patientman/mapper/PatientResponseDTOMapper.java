package com.patientman.patientman.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.patientman.patientman.dto.PatientResponseDTO;
import com.patientman.patientman.models.Patient;
public class PatientResponseDTOMapper {
    // maps patient to patient response
    public static PatientResponseDTO mapToPatientResponseDTO(Patient patient) {        
        return new PatientResponseDTO(
                patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE),
                patient.getRegisteredDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
    // maps list of patients to list of patient responses
    public static List<PatientResponseDTO> mapToPatientResponseDTOList(List<Patient> patients) {
        return patients.stream().map(PatientResponseDTOMapper::mapToPatientResponseDTO).collect(Collectors.toList());
    }

    // maps patient response to patient
    public static Patient mapToPatient(PatientResponseDTO patientResponseDTO) {
        return new Patient(
                UUID.fromString(patientResponseDTO.getId()) ,
                patientResponseDTO.getName(),
                patientResponseDTO.getEmail(),
                patientResponseDTO.getAddress(),
                LocalDate.parse(patientResponseDTO.getDateOfBirth()),
                LocalDate.parse(patientResponseDTO.getRegisteredDate()));
    }
    // maps list of patient responses to list of patients
    public static List<Patient> mapToPatientList(List<PatientResponseDTO> patientResponseDTOs) {
        return patientResponseDTOs.stream().map(PatientResponseDTOMapper::mapToPatient).collect(Collectors.toList());
    }
}
