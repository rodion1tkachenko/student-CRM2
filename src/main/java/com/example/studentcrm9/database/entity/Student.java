package com.example.studentcrm9.database.entity;

import com.example.studentcrm9.database.enums.Faculty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "account")
@EqualsAndHashCode(exclude = "account")
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Faculty faculty;
    @Column(name = "group_number")
    private Integer group;
//25.12
    public void setAccount(Account account) {
        this.account = account;
        account.setStudent(this);
    }
}
