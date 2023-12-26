package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.annotations.NameHasNoDigits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import org.springframework.stereotype.Component;

@Builder
@NameHasNoDigits
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
