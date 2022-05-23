package com.examplecodebuffer.sprinboot.service;

import com.examplecodebuffer.sprinboot.entity.Department;
import com.examplecodebuffer.sprinboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
@Autowired
    private DepartmentService departmentService;

@MockBean
private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
     Department department= Department.builder().name("Rooney")
             .address("United").code("10").deptID(1L).build();

        Mockito.when(departmentRepository.findByName("Rooney")).
                thenReturn(department);
    }
    @Test
    @DisplayName("Name ka unit test")
    public void WhenValidDepartmentName_thenDepartmentShouldFound(){
        String name="Rooney";
        Department found = departmentService.fetchDepartmentByName(name);

        assertEquals(name, found.getName());
    }
}