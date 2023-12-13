package com.example.studentcrm9;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.repository.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        AccountRepository accountRepository = context.getBean(AccountRepository.class);
        accountRepository.save(Account.builder()
                .login("petya")
                .password("228")
                .role(Role.USER)
                        .student(Student.builder()
                                .firstName("A")
                                .lastName("B")
                                .faculty(Faculty.AMM)
                                .group(1)
                                .build())
                .build());

    }

}
