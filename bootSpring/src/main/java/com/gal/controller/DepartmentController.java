package com.gal.controller;
import com.gal.model.Department;
import com.gal.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/register")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
    {
        Department department1 = departmentService.saveDepartment(department);
        return ResponseEntity.ok(department1);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments()
    {
        List<Department> list = departmentService.getAllDepartment();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/department")
    public ResponseEntity<Department> getDepartmentById(@RequestParam("id") int deptId)
    {
        Department d1 = departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(d1);
    }

}
