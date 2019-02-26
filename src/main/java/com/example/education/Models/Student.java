package com.example.education.Models;
import javax.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = students)
public class Student {

    @Id @GeneratedValue
    private int id;

    @column(length = 10)
    private String SchoolYr;

    @column
    private int Campus;

    @column
    private long StudentID;

//    @column
//    private date EntryDate;

    @column
    private long GradeLevel;

    @column(length = 100)
    private String firstName;

    @column(length = 100)
    private String middleName;

    @column (nullable = false, length = 100)
    private String lastName;

//    id int(10) unsigned NOT NULL AUTO_INCREMENT,
//    school_yr VARCHAR(10),
//    campus INT,
//    student_id LONG,
//    entry_date DATE,
//    grade_Level INT,
//    first_name VARCHAR(100),
//    middle_name VARCHAR(100),
//    last_name VARCHAR(100) NOT NULL,

}
