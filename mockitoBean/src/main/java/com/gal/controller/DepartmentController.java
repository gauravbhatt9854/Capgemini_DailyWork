package com.gal.controller;

import com.gal.dao.DepartmentDao;
import com.gal.dto.DepartmentDto;
import com.gal.model.Department;
import com.gal.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Department> getDeptById(@RequestParam(name = "id") long id){
        return ResponseEntity.ok(departmentService.getDeptById(id));

    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody Department department){
        System.out.println("inside the postmapping");
        System.out.println(department);
//        Department department1 = departmentService.addDepartment(department);
        return ResponseEntity.ok(new DepartmentDto(department));
    }
}
