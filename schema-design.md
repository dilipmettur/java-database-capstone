# Database Design - Smart Clinic Management System

## 1. Entity Relationship Overview
The system uses a relational MySQL database to manage the interactions between Doctors, Patients, and their Appointments.

## 2. Table Schemas

### Doctor Table
| Column | Type | Constraints |
| :--- | :--- | :--- |
| doctor_id | INT | Primary Key, Auto Increment |
| name | VARCHAR(100) | Not Null |
| speciality | VARCHAR(100) | Not Null |
| email | VARCHAR(100) | Unique, Not Null |

### Patient Table
| Column | Type | Constraints |
| :--- | :--- | :--- |
| patient_id | INT | Primary Key, Auto Increment |
| name | VARCHAR(100) | Not Null |
| contact_info | VARCHAR(150) | Not Null |

### Appointment Table
| Column | Type | Constraints |
| :--- | :--- | :--- |
| appointment_id | INT | Primary Key, Auto Increment |
| doctor_id | INT | Foreign Key (Doctor) |
| patient_id | INT | Foreign Key (Patient) |
| appointment_date| DATE | Not Null |
| status | VARCHAR(50) | Not Null |

## 3. Stored Procedures
The following procedures are implemented for reporting:
* `GetDailyAppointmentReportByDoctor`: Daily schedule for doctors.
* `GetDoctorWithMostPatientsByMonth`: Monthly analytics.
* `GetDoctorWithMostPatientsByYear`: Yearly analytics.
