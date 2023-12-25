package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.mapper.AccountCreateMapper;
import com.example.studentcrm9.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
//    private final RegistrationMapper registrationMapper;
    private final AccountRepository accountRepository;
    private final AccountCreateMapper accountCreateMapper;
    private final StudentService studentService;

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
    public Optional<Account> saveAccount(RegistrationDto accountDto) {
        return accountRepository.saveAccount(
//                accountCreateMapper.map(accountDto));
                accountCreateMapper.map(accountDto));
    }
    public String getLoginRedirect(Model model, Account account){
        return checkAccount(account.getLogin(), account.getPassword())
                .map(obj -> getPathDependsOnRole(model, obj))
                .orElseThrow(
                        NoSuchElementException::new
                );
    }
    public String getPathDependsOnRole(Model model, Account obj) {
        if (obj.getRole().equals(Role.USER)) {
            return redirectUserWithAttributes(model, obj);
        }
        else{
            return "redirect:/admin";
        }
    }

    private String redirectUserWithAttributes(Model model, Account obj) {
        Student student = obj.getStudent();
        studentService.setStudentAttributes(model, student);
        studentService.setGroupMateAttribute(model, student);
        return "redirect:/students/" + student.getId();
    }

}
