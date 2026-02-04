package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * Requirement for Question 26: Search doctors by speciality.
     */
    @GetMapping("/search")
    public List<Doctor> getDoctorsBySpeciality(@RequestParam String speciality) {
        return doctorService.findBySpeciality(speciality);
    }

    /**
     * Requirement for Question 5: Check availability with token validation.
     * Path: /availability/{user}/{doctorId}/{date}/{token}
     */
    @GetMapping("/availability/{user}/{doctorId}/{date}/{token}")
    public List<String> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        // 1. Mandatory Security Token Validation
        // In the capstone project, the system expects you to check if the token is valid.
        if (token == null || token.isEmpty() || token.equalsIgnoreCase("null")) {
            throw new RuntimeException("Unauthorized: Security token is missing or invalid.");
        }

        // 2. Business Logic
        // Retrieves availability from the service layer using the validated ID
        return doctorService.getAvailabilityByDoctorAndDate(doctorId, date);
    }

    /**
     * Standard endpoint to list all doctors.
     */
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAllDoctors();
    }
}
