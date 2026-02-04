package com.smartclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/doctor-login")
     public String doctorLogin() {
     return "doctor-login"; // This looks for doctor-login.html in the templates folder
    }

    @GetMapping("/patient-login")
     public String patientLogin() {
     return "patient-login"; // This points to patient-login.html
    }
    @GetMapping("/admin/add-doctor")
     public String addDoctorForm() {
     return "add-doctor"; // This points to add-doctor.html
    }
    @GetMapping("/patient/search")
     public String searchDoctor() {
     return "search-doctor"; // This points to search-doctor.html
    }
    @GetMapping("/doctor/appointments")
     public String viewAppointments() {
     return "doctor-appointments"; // This points to doctor-appointments.html
    }
}
