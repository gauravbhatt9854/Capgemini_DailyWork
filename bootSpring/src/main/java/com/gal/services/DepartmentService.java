package com.gal.services;

import com.gal.model.Department;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();

    Department getDepartmentById(int deptId);

    Department deleteDepartment(int deptId);

    Department updateDeptName(int deptId , String newName);

    Department findByName(String name);
}
