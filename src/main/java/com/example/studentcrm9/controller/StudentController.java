package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.service.AccountInfoService;
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
    private final AccountInfoService accountInfoService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAllByFaculty(Faculty.AMM));
        return "student/students";
    }

    @GetMapping("/{id}")
    public String showAccountPage(@PathVariable("id") Long id, Model model) {
        studentService.setAttributesByAccountId(id, model);
        return "student/student";
    }

    @GetMapping("/registration")
    public String registration(Model model,
                               @ModelAttribute("accountInfoDto") AccountInfoDto accountInfoDto) {
        setRegistrationAttributes(model, accountInfoDto);
        return "registration/registration";
    }

    private void setRegistrationAttributes(Model model, AccountInfoDto accountInfoDto) {
        model.addAttribute("accountInfoDto", accountInfoDto);
        model.addAttribute("roles", Role.values());
        model.addAttribute("faculties", Faculty.values());
    }

    @PostMapping("/registration")
    public String registration(@Validated @ModelAttribute("accountInfoDto") AccountInfoDto accountInfoDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        return accountInfoService.registrationRedirect(accountInfoDto, bindingResult, redirectAttributes);
    }


}
