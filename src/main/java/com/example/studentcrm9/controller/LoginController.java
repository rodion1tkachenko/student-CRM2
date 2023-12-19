package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.AccountDto;
import com.example.studentcrm9.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;

    @GetMapping("/login")
    public String loginPage(Model model){
        return "/login/login";
    }
    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("login") Account account){
        accountService.checkAccount(account.getLogin(), account.getPassword())
                .ifPresent(
                        return
                );
        return "/login/login";
    }

}
