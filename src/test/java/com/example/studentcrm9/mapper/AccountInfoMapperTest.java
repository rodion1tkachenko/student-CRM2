package com.example.studentcrm9.mapper;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.dto.AccountInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(
        SpringExtension.class
)
class AccountInfoMapperTest {
    @Autowired
    private AccountInfoMapper accountInfoMapper;
    AccountInfo ACCOUNT_PETR= AccountInfo.builder()
            .login("petya@mail.ru")
            .password("123")
            .firstName("Petr")
            .lastName("Sherbakov")
            .faculty(Faculty.AMM)
            .build();
    AccountInfoDto ACCOUNT_DTO_ANDREW= AccountInfoDto.builder()
            .login("andrew12@mail.ru")
            .password("123")
            .firstName("Andrew")
            .lastName("Sidorov")
            .faculty(Faculty.CS)
            .build();
    @Test
    void mapperShouldCreateAccountInfoDtoFromAccountInfo(){
        AccountInfoDto accountInfoDto = accountInfoMapper.mapToAccountInfoDto(ACCOUNT_PETR);
        assertNotNull(accountInfoDto);
        assertAll(
                ()->assertEquals( accountInfoDto.id(),ACCOUNT_PETR.getId()),
                ()->assertEquals( accountInfoDto.login(),ACCOUNT_PETR.getLogin()),
                ()->assertEquals( accountInfoDto.password(),ACCOUNT_PETR.getPassword()),
                ()->assertEquals( accountInfoDto.firstName(),ACCOUNT_PETR.getFirstName()),
                ()->assertEquals( accountInfoDto.lastName(),ACCOUNT_PETR.getLastName()),
                ()->assertEquals( accountInfoDto.faculty(),ACCOUNT_PETR.getFaculty()),
                ()->assertEquals( accountInfoDto.groupNumber(),ACCOUNT_PETR.getGroupNumber()),
                ()->assertEquals( accountInfoDto.role(),ACCOUNT_PETR.getRole())
        );
    }
    @Test
    void mapperShouldCreateAccountInfoFromAccountInfoDto(){
        AccountInfo accountInfo = accountInfoMapper.mapToAccountInfo(ACCOUNT_DTO_ANDREW);
        assertNotNull(accountInfo);
        assertAll(
                ()->assertEquals( accountInfo.getId(),ACCOUNT_DTO_ANDREW.id()),
                ()->assertEquals( accountInfo.getLogin(),ACCOUNT_DTO_ANDREW.login()),
                ()->assertEquals( accountInfo.getPassword(),ACCOUNT_DTO_ANDREW.password()),
                ()->assertEquals( accountInfo.getFirstName(),ACCOUNT_DTO_ANDREW.firstName()),
                ()->assertEquals( accountInfo.getLastName(),ACCOUNT_DTO_ANDREW.lastName()),
                ()->assertEquals( accountInfo.getFaculty(),ACCOUNT_DTO_ANDREW.faculty()),
                ()->assertEquals( accountInfo.getGroupNumber(),ACCOUNT_DTO_ANDREW.groupNumber()),
                ()->assertEquals( accountInfo.getRole(),ACCOUNT_DTO_ANDREW.role())
        );
    }
}