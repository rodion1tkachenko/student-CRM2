package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.AdminService;
import com.example.studentcrm9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final StudentService studentService;

    @GetMapping
    public String adminPage(){
        return "admin/admin";
    }
    @GetMapping("/allUsers")
    public String findAll(Model model,
                          @ModelAttribute("role") String role) {
        model.addAttribute("students", studentService.findAllByFaculty(Faculty.AMM));
        return "/admin/allUsers";
    }
    @GetMapping("/{id}" )
    public String updateUser(@PathVariable("id")Integer id,
                             Model model)
    {
        studentService.setAttributesByAccountId(id.longValue(),model);
        return "/admin/update";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Integer id,@ModelAttribute AccountInfoDto accountInfoDto){
        return "redirect:/admin/"+id;
    }

    @GetMapping("/delete")
    public String deleteUser(){
        return "admin/delete";
    }
    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute Integer id ,
                             BindingResult bindingResult){
        return "admin/delete";
    }



}
