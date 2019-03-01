package com.example.education.Repositories;
import com.example.education.Models.Student;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface StudentRepository extends CrudRepository<Student, Long>{
    ArrayList<Student> findAllByFirstNameIsStartingWith(String firstName);
    ArrayList<Student> findAllByMiddleNameIsStartingWith(String lastName);
    ArrayList<Student> findAllByLastNameIsStartingWith(String lastName);
    ArrayList<Student> findAllBySIdStartingWith(String studentId);
    ArrayList<Student> findAllByGradeLevel(String gradeLevel);
    ArrayList<Student> findAllByCampusStartingWith(String campus);
}
