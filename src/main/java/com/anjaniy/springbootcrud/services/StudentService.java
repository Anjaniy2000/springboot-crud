package com.anjaniy.springbootcrud.services;
import com.anjaniy.springbootcrud.models.Student;
import com.anjaniy.springbootcrud.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(int id) {
        return studentRepo.findById(id).get();
    }

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteById(int id) {
        studentRepo.deleteById(id);
    }

    public Student update(Student student) {
        return studentRepo.save(student);
    }
}
