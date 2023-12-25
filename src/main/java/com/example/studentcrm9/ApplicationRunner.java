package com.example.studentcrm9;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.repository.AccountRepository;
import com.example.studentcrm9.service.AccountService;
import com.example.studentcrm9.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        StudentService studentService = context.getBean(StudentService.class);

    }

}
