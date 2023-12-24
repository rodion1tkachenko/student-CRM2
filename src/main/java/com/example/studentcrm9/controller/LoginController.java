package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final AccountService accountService;
    private final StudentService studentService;

    @GetMapping
    public String loginPage(Model model) {
        return "/login/login";
    }

    @PostMapping
    public String login(Model model, @ModelAttribute("account") Account account) {
        return accountService.getLoginRedirect(model,account);

    }

}
