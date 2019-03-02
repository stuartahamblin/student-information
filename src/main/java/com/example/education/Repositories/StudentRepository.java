package com.example.education.Repositories;
import com.example.education.Models.Student;
import org.springframework.data.repository.CrudRepository;
import java.util.HashSet;

public interface StudentRepository extends CrudRepository<Student, Long>{
    HashSet<Student> findAllByFirstNameIsStartingWith(String firstName);
    HashSet<Student> findAllByMiddleNameIsStartingWith(String lastName);
    HashSet<Student> findAllByLastNameIsStartingWith(String lastName);
    HashSet<Student> findAllBySIdStartingWith(String studentId);
    HashSet<Student> findAllByGradeLevel(String gradeLevel);
    HashSet<Student> findAllBySchoolYr(String schoolYr);
    HashSet<Student> findAllByCampusStartingWith(String campus);
    HashSet<Student> findAllByEntryDate(String entryDate);
    HashSet<Student> findAll();
}
