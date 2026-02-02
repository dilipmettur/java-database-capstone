package com.smartclinic.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Column(nullable = false)
    private String status; // e.g., "SCHEDULED", "COMPLETED", "CANCELLED"

    // Constructors
    public Appointment() {}

    public Appointment(Doctor doctor, Patient patient, LocalDate date, String status) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = date;
        this.status = status;
    }

    // Getters and Setters
    public int getAppointmentId() { return appointmentId; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate date) { this.appointmentDate = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
