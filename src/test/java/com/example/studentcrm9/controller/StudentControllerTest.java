package com.example.studentcrm9.controller;

import com.example.studentcrm9.controller.StudentController;
import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.Student;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.RegistrationDto;
import com.example.studentcrm9.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testFindAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/students"))
                .andExpect(model().attributeExists("students"));
    }

    @Test
    public void testShowAccountPage() throws Exception {
        Long studentId = 1L;
        Student mockStudent = new Student(); // Create a mock Student object as needed for the test
        Account mockAccount = new Account(); // Create a mock Account object as needed for the test

        // Mocking the behavior of studentService.setAttributesByAccountId
        when(studentService.setAttributesByAccountId(anyLong(), Mockito.any(Model.class))).thenReturn(mockAccount);

        mockMvc.perform(MockMvcRequestBuilders.get("/students/{id}", studentId))
                .andExpect(status().isOk())
                .andExpect(view().name("student/student"))
                .andExpect(model().attributeExists("student"))
                .andExpect(model().attribute("student", mockStudent))
                .andExpect(model().attributeExists("groupMates"));

        // You can add more assertions based on your implementation.
    }
    @Test
    public void testRegistrationForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/students/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration/registration"))
                .andExpect(model().attributeExists("registrationDto"));
    }

    @Test
    public void testSubmitRegistrationForm() throws Exception {
//        RegistrationDto registrationDto = RegistrationDto.builder()
//                .firstName("alex")
//                .lastName("alex")
//                .login("test9@mail.ru")
//                .password("123")
//                .role(Role.USER)
//                .faculty(Faculty.CS)
//                .group(1)
//                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/students/registration")
//                        .flashAttr("registrationDto", registrationDto))
                .param(RegistrationDto.Fields.firstName, "vasily")
                .param(RegistrationDto.Fields.lastName, "vasiliev")
                .param(RegistrationDto.Fields.login, "vasily@mail.ru")
                .param(RegistrationDto.Fields.password, "vasily")
                .param(RegistrationDto.Fields.faculty, "AMM")
                .param(RegistrationDto.Fields.group, "1")
                .param(RegistrationDto.Fields.role, "USER"))
                .andExpect(status().isOk())
                .andExpect(view().name("student/student"));
    }

    // Add more test methods based on your controller methods.
}
