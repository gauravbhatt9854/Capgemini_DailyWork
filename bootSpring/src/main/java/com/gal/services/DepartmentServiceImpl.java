package com.gal.services;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Department saveDepartment(Department department) {
        return  departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(int deptId) {
        return departmentDao.getById(deptId);
    }
}
