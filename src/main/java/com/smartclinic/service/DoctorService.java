package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> findBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Logic for Question 5: Retrieves a list of available times for a doctor.
     * In a real system, you might filter this by the 'date' parameter.
     */
    public List<String> getAvailabilityByDoctorAndDate(Long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
        
        // This returns the availableTimes list we added to the Doctor model earlier.
        return doctor.getAvailableTimes() != null ? doctor.getAvailableTimes() : new ArrayList<>();
    }
}
