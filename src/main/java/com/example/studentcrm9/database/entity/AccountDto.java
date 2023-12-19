package com.example.studentcrm9.database.entity;

import com.example.studentcrm9.database.enums.Role;
import jakarta.persistence.*;
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
public class AccountDto {
    private String login;
    private String password;
    private Role role;
}
