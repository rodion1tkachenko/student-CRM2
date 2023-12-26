package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AccountRepository accountRepository;
    //TODO:remove dependency from AccountService
    private final AccountService accountService;

    public String getLoginRedirect(Model model, Account account) {
        return  accountService.checkAccount(account.getLogin(), account.getPassword())
                .map(obj -> accountService.getPathDependsOnRole(model, obj))
                .orElseThrow(
                        NoSuchElementException::new
                );
    }

}
