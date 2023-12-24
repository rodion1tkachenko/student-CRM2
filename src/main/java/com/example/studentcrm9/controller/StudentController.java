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
    private final AccountService accountService;

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
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationDto", registrationDto);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/students/registration";
        }

        Optional<Account> account = accountService.saveAccount(registrationDto);
        return "redirect:/students/" + account.get().getStudent().getId();

    }

    @GetMapping("/{id}/update")
    public String updateStudent(@PathVariable("id") Long id) {
        return "update/updateStudent";
    }

//    public void setGroupMateAttribute(Model model, Student student) {
//        model.addAttribute("groupMates", studentService.findGroupMates(student));
//    }
//
//    public void setStudentAttributes(Model model, Student student) {
//        model.addAttribute("student", student);
    //24.12 commented
    //        model.addAttribute("firstName", student.getFirstName());
//        model.addAttribute("lastName", student.getLastName());
//        model.addAttribute("faculty", student.getFaculty());
//        model.addAttribute("group", student.getGroup());
//}

}
