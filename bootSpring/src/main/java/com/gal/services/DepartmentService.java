package com.gal.services;

import com.gal.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();

    Department getDepartmentById(int deptId);
}
