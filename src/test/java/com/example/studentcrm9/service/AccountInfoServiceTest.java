package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.mapper.AccountInfoMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@RequiredArgsConstructor
@SpringBootTest
class AccountInfoServiceTest {

    private final AccountInfoService accountInfoService;
    AccountInfoDto accountInfoDto = AccountInfoDto.builder()
            .login("petya@mail.ru")
            .password("123")
            .firstname("Petr")
            .lastname("Sherbakov")
            .faculty(Faculty.AMM)
            .build();
    private final AccountInfoMapper accountInfoMapper;

    @Test
    void successSave() {
        AccountInfo accountInfo = accountInfoMapper.mapToAccountInfo(accountInfoDto);
        Assertions.assertEquals(accountInfo, accountInfoService.save(accountInfoDto).get());
    }
    @Test
    void saveNullIsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                ()-> accountInfoService.save(accountInfoDto));
    }
}