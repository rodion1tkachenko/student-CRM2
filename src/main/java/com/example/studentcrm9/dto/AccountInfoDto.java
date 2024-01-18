package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.annotations.HasNoDigits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;


@Builder
public record AccountInfoDto(
        Long id,
        @Email String login,
        @Size String password,
        Role role,
        @HasNoDigits String firstName,
        @HasNoDigits String lastName,
        Faculty faculty,
        Integer groupNumber) {

}
