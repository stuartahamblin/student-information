package com.example.education.Models;
import javax.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 10)
    private String SchoolYr;

    @Column(length = 10)
    private String Campus;

    @Column(length = 10)
    private String StudentID;

    @Column(length = 20)
    private String EntryDate;

    @Column(length = 10)
    private long GradeLevel;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String middleName;

    @Column (nullable = false, length = 100)
    private String lastName;

    public Student() {
    }


}
