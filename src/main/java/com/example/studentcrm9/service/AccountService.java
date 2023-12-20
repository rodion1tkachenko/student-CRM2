package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final AccountRepository accountRepository;


    public Optional<Account> checkAccount(String login, String password) {
        return accountRepository.getAccountByLoginAndPassword(login, password);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.getAccountById(id);
    }

    @Transactional
    public void deleteAccountByLogin(String login) {
        accountRepository.deleteAccountByLogin(login);
    }

    @Transactional
    public boolean saveAccount(Account account) {
        account.getStudent().setAccount(account);
        return accountRepository.saveAccount(account);
    }
}
