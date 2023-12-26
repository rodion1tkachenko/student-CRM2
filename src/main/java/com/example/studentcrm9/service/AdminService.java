package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.repository.AccountRepository;
import com.example.studentcrm9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    public List<Student> removeById(Long id) {
        if(accountRepository.getAccountById(id).isPresent()){
            return studentRepository.removeById(id);
        }
        else{
            throw new NoSuchElementException();
        }
    }


}
