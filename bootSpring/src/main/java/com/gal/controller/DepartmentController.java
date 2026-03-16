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

    @DeleteMapping("/deleteDepartment")
    public ResponseEntity<Department> deleteDepartment(@RequestParam("id") int deptId)
    {
        Department d1 = departmentService.deleteDepartment(deptId);
        return ResponseEntity.ok(d1);
    }

    @PatchMapping("/updateDeptName")
    public ResponseEntity<Department> updateDeptName(@RequestParam("id") int deptId , @RequestParam("name") String newName)
    {
        Department d1 = departmentService.updateDeptName(deptId , newName);
        return ResponseEntity.ok(d1);
    }

    @GetMapping("/dept/{id}/{dept}/{city}")
    public ResponseEntity<Department> getDummyDept(@PathVariable int id , @PathVariable String dept , @PathVariable String city)
    {
        Department department = new Department(id, dept , city);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/dept")
    public ResponseEntity<Department> getDummyDept2(@RequestParam("id") int id , @RequestParam("dept") String dept , @RequestParam("city") String city)
    {
        Department department = new Department(id, dept , city);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/deptName")
    public ResponseEntity<Department> findByName(@RequestParam("name") String name)
    {
        Department department = departmentService.findByName(name);
        return ResponseEntity.ok(department);
    }



}
