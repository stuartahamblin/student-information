package com.example.education.Models;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 10)
    private String schoolYr;

    @Column(length = 10)
    private String campus;

    @Column(length = 10)
    private String sId;

    @Column(length = 20)
    private String entryDate;

    @Column(length = 10)
    private String gradeLevel;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String middleName;

    @Column (nullable = false, length = 100)
    private String lastName;

    public Student() {
    }

    public String getSchoolYr() {
        return schoolYr;
    }

    public void setSchoolYr(String schoolYr) {
        this.schoolYr = schoolYr;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sID) {
        sId = sID;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
