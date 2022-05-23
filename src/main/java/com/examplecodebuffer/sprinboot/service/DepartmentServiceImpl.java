package com.examplecodebuffer.sprinboot.service;

import com.examplecodebuffer.sprinboot.entity.Department;
import com.examplecodebuffer.sprinboot.error.DepartmentNotFoundException;
import com.examplecodebuffer.sprinboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department updateDepartment(long id, Department department) {
        Department depDB= departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())){
            depDB.setName(department.getName());
        }
        if(Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())){
            depDB.setCode(department.getCode());
        }

        if(Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())){
            depDB.setAddress(department.getAddress());
        }



        return  departmentRepository.save(depDB);

    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long id) throws DepartmentNotFoundException {
      Optional<Department> department= departmentRepository.findById(id);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Not found lol");
        }
        return department.get();

    }

    @Override
    public void deleteDepartmentByID(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department fetchDepartmentByName(String deptName) {

        return departmentRepository.findByName(deptName);
    }

}
