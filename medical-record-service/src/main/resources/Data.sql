CREATE DATABASE MedicalRecords;

-- Создание таблицы Doctor
CREATE TABLE Doctor (
    doctor_id SERIAL PRIMARY KEY,
    doctorLastName VARCHAR(255),
    doctorFirstName VARCHAR(255),
    doctorsSpecialization VARCHAR(255)
);
-- Создание таблицы Drug
CREATE TABLE Drug (
    drug_id SERIAL PRIMARY KEY,
    drugName VARCHAR(255),
    doseDrag DOUBLE PRECISION,
    informationOfDrug VARCHAR(255)
);

-- Создание таблицы EssenceMedicalRecords
CREATE TABLE EssenceMedicalRecords (
    record_id SERIAL PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    dateOfVisit DATE,
    diagnosis VARCHAR(255),
    treatment VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES Patient(idNamberPassport),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

-- Создание таблицы LaboratoryResults
CREATE TABLE LaboratoryResults (
    result_id SERIAL PRIMARY KEY,
    patient_id INT,

    dateOfStudy DATE,
    typeOfAnalysis VARCHAR(255),
    resultInformationAboutLaboratoryTests VARCHAR(255),
    FOREIGN KEY (patient_id) REFERENCES Patient(idNamberPassport)
);

-- Создание таблицы Patient
CREATE TABLE Patient (
    idNamberPassport SERIAL PRIMARY KEY,
    namberMedicalRecords INT,
    LastNamePatient VARCHAR(255),
    FirstNamePatient VARCHAR(255),
    adres VARCHAR(255),
    phone INT
);