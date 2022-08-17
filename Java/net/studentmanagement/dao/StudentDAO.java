package net.studentmanagement.dao;

import net.studentmanagement.model.Student;

import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student getStudent(int id);

    List<Student> getAllStudent();

}
//commit