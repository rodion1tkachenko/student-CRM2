package com.example.studentcrm9.controller;

import com.example.studentcrm9.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@AutoConfigureMockMvc
class StudentControllerTest extends IntegrationTestBase {
    private final MockMvc mockMvc;
    @Test
    void findAll(){

    }
}