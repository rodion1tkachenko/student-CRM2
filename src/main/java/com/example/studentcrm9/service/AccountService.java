package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.mapper.AccountCreateMapper;
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
    private final AccountCreateMapper accountCreateMapper;

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
    public Optional<Account> saveAccount(Account account) {
        account.getStudent().setAccount(account);
        return accountRepository.saveAccount(account);
    }
    @Transactional
    public Optional<Account> saveAccount(RegistrationDto accountDto) {
        return accountRepository.saveAccount(
                accountCreateMapper.map(accountDto));
    }
}
