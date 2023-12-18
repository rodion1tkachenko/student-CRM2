package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registration")
@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final AccountService accountService;

//    @GetMapping
//    public String registration(Model model, @ModelAttribute("account") Account account){
//        model.addAttribute("account", account);
//        model.addAttribute("roles", Role.values());
//        model.addAttribute("faculties", Faculty.values());
//        return "registration/registration";
//}
//    @PostMapping
//    public String registration(@ModelAttribute Account account){
//        accountService.saveAccount(account);
//        return "/student/student";
//    }
}
