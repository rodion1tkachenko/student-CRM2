package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAllByFaculty(Faculty.AMM));
        return "student/students";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        return studentService.findById(id)
                .map(student -> {
                    setStudentAttributes(model, student);
                    setGroupMateAttribute(model, student);
                    return "student/student";
                })
                        .orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND)
                        );
    }

    private void setGroupMateAttribute(Model model, Student student) {

    }

    private void setStudentAttributes(Model model, Student student) {
        model.addAttribute("firstName", student.getFirstName());
        model.addAttribute("lastName", student.getLastName());
        model.addAttribute("faculty", student.getFaculty());
        model.addAttribute("group", student.getGroup());
    }

}
