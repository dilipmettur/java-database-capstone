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

    // This is the specific part needed for Question 26
    @GetMapping("/search")
    public List<Doctor> getDoctorsBySpeciality(@RequestParam String speciality) {
        return doctorService.findBySpeciality(speciality);
    }

    // Existing methods...
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAllDoctors();
    }
}
