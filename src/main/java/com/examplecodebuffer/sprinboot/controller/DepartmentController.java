package com.examplecodebuffer.sprinboot.controller;

import com.examplecodebuffer.sprinboot.entity.Department;
import com.examplecodebuffer.sprinboot.error.DepartmentNotFoundException;
import com.examplecodebuffer.sprinboot.service.DepartmentService;
import com.examplecodebuffer.sprinboot.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER=
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside save department of Department controller");
        return departmentService.saveDepartment(department);

}

@GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
}

    @GetMapping("/departments/{id}")
public Department fetchDepartmentByID(@PathVariable("id") Long id) throws DepartmentNotFoundException {

        return departmentService.fetchDepartmentByID(id);
}

     @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long id){
    departmentService.deleteDepartmentByID(id);
    return "Success";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") long id, @RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String deptName){
        return departmentService.fetchDepartmentByName(deptName);}
}
