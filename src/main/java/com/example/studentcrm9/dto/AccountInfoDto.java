package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

//@ToString
@Builder
public record AccountInfoDto(
        Long id,
        String login,
        String password,
        Role role,
        String firstname,
        String lastname,
        Faculty faculty,
        Integer groupNumber
) {
}
