package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.AccountDto;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final AccountService accountService;
    private final StudentService studentService;
    private final StudentController studentController;

    @GetMapping
    public String loginPage(Model model) {
        return "/login/login";
    }
//TODO: a lot of logic here, move to service layer
    @PostMapping
    public String login(Model model, @ModelAttribute("account") AccountDto accountDto) {
         return accountService.checkAccount(accountDto.getLogin(), accountDto.getPassword())
                .map(obj -> {
                    if (obj.getRole().equals(Role.USER)) {
                        Student student = obj.getStudent();
                        studentController.setStudentAttributes(model, student);
                        studentController.setGroupMateAttribute(model, student);
                        return "redirect:/students/" + student.getId();
                    }
                    else{
                        return "redirect:/admin";
                    }
                }).orElseThrow(
                                NoSuchElementException::new
                );
//                ifPresent(obj -> {
//                    Student student = obj.getStudent();
//                    studentController.setStudentAttributes(model, student);
//                    studentController.setGroupMateAttribute(model, student);
//                });
//        return "redirect:/student/" + student.getId();
    }

}
