package com.example.studentcrm9.mapper;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.dto.AccountInfoDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AccountInfoMapper {
    AccountInfoDto accountInfoToDto(AccountInfo accountInfo);
    AccountInfo dtoToAccountInfo(AccountInfoDto accountInfoDto);
}
