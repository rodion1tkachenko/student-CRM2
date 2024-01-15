package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.annotations.NoDigitsInNameAndSurname;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;


@Builder
@NoDigitsInNameAndSurname
public record AccountInfoDto(
        Long id,
        @Email String login,
        @Size String password,
        Role role,
        String firstname,
        String lastname,
        Faculty faculty,
        Integer groupNumber) {

}
