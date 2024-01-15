package com.example.studentcrm9.mapper;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.dto.AccountInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountInfoMapper {
    AccountInfoDto mapToAccountInfoDto(AccountInfo accountInfo);
    AccountInfo mapToAccountInfo(AccountInfoDto accountInfoDto);
}
