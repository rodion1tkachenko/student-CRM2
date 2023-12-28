package com.example.studentcrm9.database.entity;

import com.example.studentcrm9.database.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "student")
@EqualsAndHashCode(exclude = "student")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login", unique = true, nullable = false, length = 64)
    @Email
    private String login;
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Student student;

    @Enumerated(EnumType.STRING)
    private Role role;
    
//    public void setStudent(Student student) {
//        this.student = student;
//        student.setAccount(this);
//    }
}
