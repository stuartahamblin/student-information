package com.example.education.Services;

import com.example.education.Models.Student;
import com.example.education.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student findOne(Long id) {
        return studentRepo.findOne(id);
    }

    public Student edit(Student student) {
        studentRepo.save(student);
        return student;
    }

}
