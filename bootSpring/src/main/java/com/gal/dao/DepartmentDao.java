package com.gal.dao;

import com.gal.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {

    List<Department> findAll();
    Department save(Department department);
    Department getById(int deptId);
}