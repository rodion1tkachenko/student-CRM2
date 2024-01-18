package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.annotations.HasNoDigits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.experimental.FieldNameConstants;

@Builder
@FieldNameConstants
public record RegistrationDto(
        @Email String login,
        @Size(min = 3, max = 32) String password,
        Role role,
        @HasNoDigits String firstName,
        @HasNoDigits String lastName,
        Faculty faculty,
        Integer group
) {
}
