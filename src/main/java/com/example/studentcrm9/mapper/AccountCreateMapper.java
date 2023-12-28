package com.example.studentcrm9.mapper;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.dto.RegistrationDto;
import org.springframework.stereotype.Component;

//TODO: i didn't make mapping with MapStruct because i map 2 hibernate entities with dto
@Component
public class AccountCreateMapper implements Mapper<RegistrationDto, Account>{
    @Override
    public Account map(RegistrationDto registrationDto) {
        Account account = setAccountFields(registrationDto);
        Student student = setStudentFields(registrationDto);
        student.setAccount(account);
        System.out.println();
        return account;
    }
//    @Override
//    public Account map(RegistrationDto registrationDto, Account toObject) {
//        toObject = setAccountFields(registrationDto);
//        Student student = setStudentFields(registrationDto);
//        student.setAccount(account);
//        System.out.println();
//        return account;
//    }
    private Account setAccountFields(RegistrationDto fromObject) {
        Account account=new Account();
        account.setLogin(fromObject.login());
        account.setPassword(fromObject.login());
        account.setRole(fromObject.role());
        return account;
    }

    private Student setStudentFields(RegistrationDto fromObject) {
        Student student=new Student();
        student.setFirstName(fromObject.firstName());
        student.setLastName(fromObject.lastName());
        student.setFaculty(fromObject.faculty());
        student.setGroup(fromObject.group());
        return student;
    }
}
