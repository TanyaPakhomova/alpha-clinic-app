package dao;

import entiti.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {
    Doctor getDoctorById(int id) throws SQLException;
    List<Doctor> getAllDoctor() throws SQLException;
    void addDoctor(Doctor doctor) throws SQLException;
    void updateDoctor(Doctor doctor) throws SQLException;
    void deleteDoctorById(int id) throws SQLException;
}
