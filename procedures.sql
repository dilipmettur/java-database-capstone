-- Procedure for Daily Appointment Report
DELIMITER //
CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN docId INT, IN reportDate DATE)
BEGIN
    SELECT a.appointment_id, p.name AS patient_name, a.status
    FROM Appointment a
    JOIN Patient p ON a.patient_id = p.patient_id
    WHERE a.doctor_id = docId AND a.appointment_date = reportDate;
END //

-- Procedure for Monthly Analytics
CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(IN reportMonth INT, IN reportYear INT)
BEGIN
    SELECT d.name, COUNT(a.patient_id) AS total_patients
    FROM Doctor d
    JOIN Appointment a ON d.doctor_id = a.doctor_id
    WHERE MONTH(a.appointment_date) = reportMonth AND YEAR(a.appointment_date) = reportYear
    GROUP BY d.doctor_id
    ORDER BY total_patients DESC LIMIT 1;
END //
DELIMITER ;
