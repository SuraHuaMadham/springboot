package com.examplecodebuffer.sprinboot.service;

import com.examplecodebuffer.sprinboot.entity.Department;
import com.examplecodebuffer.sprinboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department updateDepartment(long id, Department department);

   public  Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   Department fetchDepartmentByID(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentByID(long id);

  public  Department fetchDepartmentByName(String deptName);
}
