package dao;

import entiti.Doctor;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO{
    private final Connection connection;

    public DoctorDAOImpl() throws SQLException {
        connection = DBConnection.getConnection();
    }

    @Override
    public Doctor getDoctorById(int id) throws SQLException {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        String query = "SELECT * FROM doctors WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractDoctorFromResultSet(resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctor() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM Doctor";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                doctors.add(extractDoctorFromResultSet(resultSet));
            }
        }
        return doctors;
    }

    @Override
    public void addDoctor(Doctor doctor) throws SQLException {
        if (doctor.getDoctorFirstName() == null || doctor.getDoctorFirstName().isEmpty()) {
            throw new IllegalArgumentException("DoctorFirstName cannot be empty");
        }
        if (doctor.getDoctorLastName() == null || doctor.getDoctorLastName().isEmpty()) {
            throw new IllegalArgumentException("DoctorFirstName cannot be empty");
        }
        if (doctor.getDoctorsSpecialization() == null || doctor.getDoctorsSpecialization().isEmpty()) {
                throw new IllegalArgumentException("DoctorsSpecialization cannot be empty");
        }
        String query = "INSERT INTO doctors (doctorLastName, doctorFirstName, doctorsSpecialization (?, ?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getDoctorLastName());
            statement.setString(2, doctor.getDoctorLastName());
            statement.setString(3, doctor.getDoctorsSpecialization());
            statement.executeUpdate();
        }
    }



    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        int doctorId = doctor.getDoctor_id();

        if (getDoctorById(doctorId) == null) {
            throw new IllegalArgumentException("Doctor with ID " + doctorId+ " does not exist");
        }
        String query = "UPDATE doctors SET doctorLastName = ?, doctorFirstName = ?, doctorsSpecialization = ? WHERE Doctor_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, doctor.getDoctorLastName());
            statement.setString(2, doctor.getDoctorFirstName());
            statement.setInt(3, doctor.getDoctor_id());
            statement.setString(4, doctor.getDoctorsSpecialization());
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteDoctorById(int id) throws SQLException {
        if (getDoctorById(id) == null) {
            throw new IllegalArgumentException("Doctor with ID " + id + " does not exist");
        }
        String query = "DELETE FROM doctors WHERE doctor_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Doctor extractDoctorFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("doctor_id");
        String doctorlastname = resultSet.getString("doctorLastName");
        String doctorfirstname = resultSet.getString("doctorFirstName");
        String doctorsspecialization  = resultSet.getString("doctorFirstName");
        return new Doctor(id,doctorlastname,doctorfirstname,doctorsspecialization);
    }
}
