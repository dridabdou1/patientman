package com.patientman.patientman.repositories.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.internal.XMLContext.Default;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.patientman.patientman.dto.PatientCreateDTO;
import com.patientman.patientman.dto.PatientResponseDTO;
import com.patientman.patientman.dto.PatientUpdateDTO;
import com.patientman.patientman.mapper.PatientCreateDTOMapper;
import com.patientman.patientman.mapper.PatientResponseDTOMapper;
import com.patientman.patientman.mapper.PatientUpdateDTOMapper;
import com.patientman.patientman.models.Patient;
import com.patientman.patientman.repositories.PatientRepository;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    // constructor
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // create get getlist  update and delete operation using PatientReposeDTO and mapper
    public List<PatientResponseDTO> getAll(){    
        return PatientResponseDTOMapper.mapToPatientResponseDTOList(patientRepository.findAll());    
    }    

    public PatientResponseDTO getById(UUID id){
        return PatientResponseDTOMapper.mapToPatientResponseDTO(patientRepository.findById(id).get());
    }

    public PatientResponseDTO create(PatientCreateDTO patientResponseDTO){
        Patient patient = PatientCreateDTOMapper.mapToPatient(patientResponseDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientResponseDTOMapper.mapToPatientResponseDTO(savedPatient);
    }

    public Optional<PatientResponseDTO> update(PatientUpdateDTO patientUpdateDTO){
        return patientRepository.findById(UUID.fromString(patientUpdateDTO.getId()))
        .map( existingPatient ->  {  
            PatientUpdateDTOMapper.mapToPatient(patientUpdateDTO, existingPatient);
            return existingPatient; 
        })
        .map(patientRepository::save)
        .map(PatientResponseDTOMapper::mapToPatientResponseDTO);
    }

    public void delete(UUID id){
        patientRepository.deleteById(id);
    }
} 
