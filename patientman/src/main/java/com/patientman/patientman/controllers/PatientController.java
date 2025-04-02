package com.patientman.patientman.controllers;
// create patient controller

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patientman.patientman.dto.PatientCreateDTO;
import com.patientman.patientman.dto.PatientResponseDTO;
import com.patientman.patientman.dto.PatientUpdateDTO;
import com.patientman.patientman.repositories.services.PatientService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // create get getlist  update and delete operation using PatientReposeDTO and mapper
    @GetMapping
    public List<PatientResponseDTO> getAll(){
        return patientService.getAll();
    }

    // get by id
    @GetMapping("/{id}")
    public PatientResponseDTO getById(@PathVariable UUID id){
        return patientService.getById(id);
    }

    // create
    @PostMapping
    public PatientResponseDTO create(@RequestBody PatientCreateDTO dto){
        return patientService.create(dto);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,@RequestBody PatientUpdateDTO dto){
        Optional<PatientResponseDTO> response =  patientService.update(dto);

        // handle both cases
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }else{
            // return 404
            return ResponseEntity.status(404).body("Patient doesn't exist");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        patientService.delete(id);
    }
}

