package com.example.studentcrm9.controller;

import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.AdminService;
import com.example.studentcrm9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @GetMapping
    public String adminPage(){
        return "admin/admin";
    }
    @PostMapping
    public String admin(@ModelAttribute("id") Integer id){
        adminService.removeById(id.longValue());
        return "redirect:/admin";
    }

}
