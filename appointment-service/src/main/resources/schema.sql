CREATE TABLE appointments (
                              appointment_id INT AUTO_INCREMENT PRIMARY KEY,
                              appointment_time DATETIME NOT NULL,
                              patient_name VARCHAR(255) NOT NULL,
                              doctor_name VARCHAR(255) NOT NULL,
                              specialization VARCHAR(255),
                              notes TEXT );