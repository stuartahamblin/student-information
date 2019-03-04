package com.example.education.Controllers;
import com.example.education.Models.Student;
import com.example.education.Repositories.StudentRepository;
import com.example.education.Services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@Controller
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepo;

    public StudentController(StudentService studentService, StudentRepository studentRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/students")
    public String welcome(Model model){
        model.addAttribute("allStudents", studentRepo.findAll());
        return "students";
    }

    @PostMapping("/students")
    public String searchStudents(Model model, @RequestParam(name = "student-search") String studentSearch, @RequestParam(name = "search-criteria") String searchCriteria){
        HashSet<Student> searchResults;
        switch(searchCriteria){
            case("1"):
                searchResults = studentRepo.findAllByFirstNameIsStartingWith(studentSearch);
                searchResults.addAll(studentRepo.findAllByMiddleNameIsStartingWith(studentSearch));
                searchResults.addAll(studentRepo.findAllByLastNameIsStartingWith(studentSearch));
                searchResults.addAll(studentRepo.findAllBySIdStartingWith(studentSearch));
                searchResults.addAll(studentRepo.findAllByGradeLevel(studentSearch));
                searchResults.addAll(studentRepo.findAllByCampusStartingWith(studentSearch));
                searchResults.addAll(studentRepo.findAllBySchoolYr(studentSearch));
                searchResults.addAll(studentRepo.findAllByEntryDate(studentSearch));
                model.addAttribute("searchResults", searchResults);
                break;
            case("2"):
                searchResults = studentRepo.findAllByFirstNameIsStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("3"):
                searchResults = studentRepo.findAllByLastNameIsStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("4"):
                searchResults = studentRepo.findAllBySIdStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("5"):
                searchResults = studentRepo.findAllByGradeLevel(studentSearch);
                model.addAttribute("searchResults", searchResults);
                break;
            case("6"):
                searchResults =studentRepo.findAllByCampusStartingWith(studentSearch);
                model.addAttribute("searchResults", searchResults);
        }
        return "/student/results";
    }

    @GetMapping("/student/results")
    public String showResults(@ModelAttribute (name="searchResults") HashSet<Student> searchResults, Model model){
        return "student/results";
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
        studentRepo.save(student);

        return "redirect:/students";
    }

    @GetMapping("/student/{id}/edit")
    public String viewEditStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findOne(id));
        return "student/edit";
    }

    @PostMapping("/student/{id}/edit")
    public String editStudent(@ModelAttribute Student student){
        studentService.edit(student);
        return "redirect:/students";
    }


}
