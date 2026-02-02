package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String speciality;

    @Column(unique = true, nullable = false)
    private String email;

    // One doctor can have many appointments
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // Constructors
    public Doctor() {}

    public Doctor(String name, String speciality, String email) {
        this.name = name;
        this.speciality = speciality;
        this.email = email;
    }

    // Getters and Setters
    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
