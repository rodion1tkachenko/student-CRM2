package com.example.studentcrm9.controller;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.AdminService;
import com.example.studentcrm9.service.LoginService;
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
    private final LoginService loginService;

    @GetMapping
    public String loginPage(Model model) {
        return "/login/login";
    }

    //    @PostMapping
//    public String login(Model model, @ModelAttribute("account") Account account) {
//        return loginService.getLoginRedirect(model,account);
//
//    }
    @PostMapping
    public String login(Model model, @ModelAttribute("account") AccountInfoDto accountInfoDto) {
        return loginService.getLoginRedirect(model, accountInfoDto);

    }

}
