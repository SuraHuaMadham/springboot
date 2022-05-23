package com.examplecodebuffer.sprinboot.controller;

import com.examplecodebuffer.sprinboot.entity.Department;
import com.examplecodebuffer.sprinboot.error.DepartmentNotFoundException;
import com.examplecodebuffer.sprinboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)

class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department=Department.builder()
                .address("UTD").name("Rashford").code("10").deptID(1L).build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment=Department.builder().
                address("UTD").name("Rashford").code("10").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON).content("{\n" +
                        "\t\"name\":\"Rashford\" ,\n" +
                        "\t\"address\":\"UTD\",\n" +
                        "\t\"code\":\"10\"\n" +
                        "}")).andExpect((status().isOk()));
    }

    @Test
    void fetchDepartmentByID() throws Exception {

        Mockito.when(departmentService.fetchDepartmentByID(1L)).thenReturn(department);

        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(department.getName()));

    }
}