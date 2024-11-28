package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO 
{

    // CREATE Operation (Insert a new student)
    public void createStudent(Student student) 
    {
        String query = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    // READ Operation (Get a student by ID)
    public Student getStudentById(int id) 
    {
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    // READ Operation (Get all students)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("grade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // UPDATE Operation (Update a student's details)
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.setInt(4, student.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE Operation (Delete a student by ID)
    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Student deleted successfully.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
