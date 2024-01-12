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
@FieldNameConstants
public record RegistrationDto(
        @Email String login,
        @Size(min = 3, max = 32) String password,
        Role role,
        String firstName,
        String lastName,
        Faculty faculty,
        Integer group
) {
}
