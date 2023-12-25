package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.mapper.AccountCreateMapper;
import com.example.studentcrm9.repository.AccountRepository;
import com.example.studentcrm9.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final AccountCreateMapper accountCreateMapper;
//    private final RegistrationMapper registrationMapper;


    @Query("update Student s set s.firstName = ?1, s.lastName = ?2 where s.id = ?3")
    @Modifying
    public void setStudentInfoById(Student student, Long userId) {
        studentRepository.setStudentInfoById(student.getFirstName(),
                student.getLastName(),
                userId);
    }
//TODO: why this method returns account?
    public Account setAttributesByAccountId(Long id, Model model) {
        return studentRepository.findById(id)
                .map(student -> {
                    setStudentAttributes(model, student);
                    setGroupMateAttribute(model, student);
                    return student.getAccount();
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );


    }
//TODO: no service logic in method. logic is in controller layer
    public List<Student> findAllByFaculty(Faculty faculty) {
        return studentRepository.findAllByFaculty(faculty);
    }

    private Optional<Account> findAccountById(Long id) {
        return accountRepository.getAccountById(id);
    }

    public List<Student> findGroupMates(Student student) {
        return studentRepository.findAllByFacultyAndGroup(student.getFaculty(),student.getGroup())
                .stream()
                .filter(object-> !student.equals(object))
                .distinct()
                .collect(Collectors.toList());
    }
    public void setGroupMateAttribute(Model model, Student student) {
        model.addAttribute("groupMates", findGroupMates(student));
    }
    public void setStudentAttributes(Model model, Student student) {
        model.addAttribute("student", student);
    }
    public void setRegistrationAttributes(Model model,  RegistrationDto registrationDto) {
        model.addAttribute("registrationDto", registrationDto);
        model.addAttribute("roles", Role.values());
        model.addAttribute("faculties", Faculty.values());
    }
    public String registrationRedirect( RegistrationDto registrationDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return redirectToRegistration(registrationDto, bindingResult, redirectAttributes);
        }
        return redirectToAccount(registrationDto);

    }

    private String redirectToAccount(RegistrationDto registrationDto) {
        Optional<Account> account = saveAccount(registrationDto);
        return "redirect:/students/" + account.get().getStudent().getId();
    }
    @Transactional
    public Optional<Account> saveAccount(RegistrationDto accountDto) {
        return accountRepository.saveAccount(
                accountCreateMapper.map(accountDto));
    }

        private static String redirectToRegistration(RegistrationDto registrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("registrationDto", registrationDto);
        redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        return "redirect:/students/registration";
    }


}
