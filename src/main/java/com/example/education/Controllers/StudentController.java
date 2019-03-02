package com.example.education.Controllers;
import com.example.education.Models.Student;
import com.example.education.Repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@Controller
public class StudentController {

    public final StudentRepository studentDao;

    public StudentRepository getStudentDao() {
        return studentDao;
    }

    public StudentController(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/search")
    public String welcome(Model model){
        model.addAttribute("allStudents", studentDao.findAll());
        return "search";
    }

    @PostMapping("/search")
    public String searchStudents(Model model, @RequestParam(name = "student-search") String studentSearch, @RequestParam(name = "search-criteria") String searchCriteria){
        HashSet<Student> searchResults;
        switch(searchCriteria){
            case("1"):
                searchResults = studentDao.findAllByFirstNameIsStartingWith(studentSearch);
                searchResults.addAll(studentDao.findAllByMiddleNameIsStartingWith(studentSearch));
                searchResults.addAll(studentDao.findAllByLastNameIsStartingWith(studentSearch));
                searchResults.addAll(studentDao.findAllBySIdStartingWith(studentSearch));
                searchResults.addAll(studentDao.findAllByGradeLevel(studentSearch));
                searchResults.addAll(studentDao.findAllByCampusStartingWith(studentSearch));
                searchResults.addAll(studentDao.findAllBySchoolYr(studentSearch));
                searchResults.addAll(studentDao.findAllByEntryDate(studentSearch));
                model.addAttribute("searchResults", searchResults);
                break;
            case("2"):
                searchResults = studentDao.findAllByFirstNameIsStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("3"):
                searchResults = studentDao.findAllByLastNameIsStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("4"):
                searchResults = studentDao.findAllBySIdStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("5"):
                searchResults = studentDao.findAllByGradeLevel(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("6"):
                searchResults =studentDao.findAllByCampusStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
        }
        return "/search/results";
    }

    @GetMapping("/search/results")
    public String showResults(@ModelAttribute (name="searchResults") HashSet<Student> searchResults, Model model){
        return "search/results";
    }

    @GetMapping("/student/add")
    public String navAddStudent(Model model){
        return "student/add";
    }

    @PostMapping("student/add")
    public String addStudent(@RequestParam(name = "fName") String fName,
                             @RequestParam(name = "mName") String mName,
                             @RequestParam(name = "lName") String lName,
                             @RequestParam(name = "sid") String sid,
                             @RequestParam(name = "grade") String grade,
                             @RequestParam(name = "year") String year,
                             @RequestParam(name = "campus") String campus){
        Student student = new Student(fName, mName, lName, sid, grade, year, campus);
        studentDao.save(student);

        return "redirect:/search";
    }


}
