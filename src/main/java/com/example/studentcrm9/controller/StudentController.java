package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.StudentService;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public String findAll(Model model,
                          @ModelAttribute("role") String role) {
        model.addAttribute("students", studentService.findAllByFaculty(Faculty.AMM));
//        if(role.equals("ADMIN")){
//            redirectAttributes.addAttribute("role","ADMIN");
//        }
        return "student/students";
    }

    @GetMapping("/{id}")
    public String showAccountPage(@PathVariable("id") Long id, Model model, @ModelAttribute("role")String role) {
        studentService.setAttributesByAccountId(id, model);
        return "student/student";
    }
    @PostMapping("/{id}")
    public String showAccountPage(@PathVariable("id") Long id) {
        System.out.println("update");
        return "student/student";

    }

    @PostMapping
    public String findByStudentId(@ModelAttribute Student student) {
        return "student/student";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("registrationDto") RegistrationDto registrationDto) {
        studentService.setRegistrationAttributes(model, registrationDto);
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String registration(@Validated(Default.class) @ModelAttribute("registrationDto") RegistrationDto registrationDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        return studentService.registrationRedirect(registrationDto, bindingResult, redirectAttributes);

    }



}
