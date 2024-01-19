package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.mapper.AccountInfoMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountInfoServiceTest {

    private  AccountInfoService accountInfoService;
    AccountInfoDto accountInfoDto = AccountInfoDto.builder()
            .login("petya@mail.ru")
            .password("123")
            .firstName("Petr")
            .lastName("Sherbakov")
            .faculty(Faculty.AMM)
            .build();
    private AccountInfoMapper accountInfoMapper;

    @Test
    void shouldSaveAccountInfoSuccessfully() {
        AccountInfo accountInfo = accountInfoMapper.mapToAccountInfo(accountInfoDto);
        Assertions.assertEquals(accountInfo, accountInfoService.save(accountInfoDto).get());
    }
    @Test
    void shouldThrowNpeWhenAccountInfoIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                ()-> accountInfoService.save(accountInfoDto));
    }
}