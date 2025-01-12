package jdbc;
public class Main
{
    public static void main(String[] args)
    {
        StudentDAO studentDAO = new StudentDAO();

        // CREATE - Add a new student
        Student student1 = new Student(0, "Gokul", 20, "A");
        studentDAO.createStudent(student1);

        // READ - Get student by ID
        Student studentFromDB = studentDAO.getStudentById(1);
        if (studentFromDB != null) 
        {
            System.out.println("Student Details: " + studentFromDB.getName() + ", " + studentFromDB.getAge() + ", " + studentFromDB.getGrade());
        }

        // READ - Get all students
        System.out.println("All Students:");
        for (Student student : studentDAO.getAllStudents()) 
        {
            System.out.println(student.getId() + ": " + student.getName() + ", " + student.getAge() + ", " + student.getGrade());
        }

        // UPDATE - Update student details
        student1.setAge(21);
        student1.setGrade("B");
        studentDAO.updateStudent(student1);

        // DELETE - Delete a student by ID
        studentDAO.deleteStudent(1);
    }
}
