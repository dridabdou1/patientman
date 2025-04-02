package com.patientman.patientman.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patientman.patientman.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    

}
