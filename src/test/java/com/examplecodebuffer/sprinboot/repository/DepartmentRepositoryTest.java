package com.examplecodebuffer.sprinboot.repository;

import com.examplecodebuffer.sprinboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department=Department.builder().name("Yo").address("Liverpool").code("10").build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnID(){

        Department department=departmentRepository.findById(1L).get();

        assertEquals(department.getName(), "Yo");
    }

}