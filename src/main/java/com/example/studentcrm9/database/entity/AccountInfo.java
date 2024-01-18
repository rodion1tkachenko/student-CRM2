package com.example.studentcrm9.database.entity;

import com.example.studentcrm9.database.enums.*;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "id")
@Entity
@Builder
@Table(name = "account_info")
public class AccountInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true, nullable = false, length = 128)
    private String login;

    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 64, columnDefinition = "varchar(64) default 'USER'")
    private Role role;

    @Column(name = "firstname", nullable = false, length = 64)
    private String firstName;

    @Column(name = "lastname", length = 64, columnDefinition = "varchar(64) default ''")
    private String lastName = "";
    @Enumerated(EnumType.STRING)
    @Column(name = "faculty", length = 64, columnDefinition = "varchar(64) default 'AMM'")
    private Faculty faculty;

    @Column(name = "group_number", columnDefinition = "integer default 1")
    private Integer groupNumber;

}
