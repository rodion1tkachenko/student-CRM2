package com.example.studentcrm9.dto;

import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.annotations.NameHasNoDigits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@NameHasNoDigits
public class RegistrationDto {
    @Email
    private String login;
    @Size(min = 3,max = 32)
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private Faculty faculty;
    private Integer group;

}
