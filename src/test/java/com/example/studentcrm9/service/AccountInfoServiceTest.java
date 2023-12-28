package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.database.enums.Faculty;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
@Component
@RequiredArgsConstructor
@SpringBootTest
class AccountInfoServiceTest {

    private final AccountInfoService accountInfoService;
        AccountInfo accountInfo= AccountInfo.builder()
            .login("petya@mail.ru")
            .password("123")
            .firstname("Petr")
            .lastname("Sherbakov")
            .faculty(Faculty.AMM)
            .build();
    @Test
    void service() {
        System.out.println(accountInfoService.service(accountInfo));
    }
}