package net.studentmanagement.service.impl;

import net.studentmanagement.dao.StudentDAO;
import net.studentmanagement.model.Student;
import net.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public List<Student> getAllStudent() {
        //List <Student> listOfStudents = new ArrayList<>();
        return studentDAO.getAllStudent();
    }
}
//commit
