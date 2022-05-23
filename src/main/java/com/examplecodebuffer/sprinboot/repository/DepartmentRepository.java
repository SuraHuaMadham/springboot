package com.examplecodebuffer.sprinboot.repository;

import com.examplecodebuffer.sprinboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department,Long>{

    public Department findByName(String deptName);

    public Department findByNameIgnoreCase(String deptName);

}
