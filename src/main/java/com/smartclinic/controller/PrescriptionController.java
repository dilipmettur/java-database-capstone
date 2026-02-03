package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping("/issue")
    public Map<String, String> issuePrescription(@RequestParam int appointmentId, @RequestBody String medicineDetails) {
        // Logic to link prescription to appointment
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Prescription issued for Appointment ID: " + appointmentId);
        return response;
    }
}
