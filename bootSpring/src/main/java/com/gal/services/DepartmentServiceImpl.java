package com.gal.services;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public Department saveDepartment(Department department) {
        System.out.println("Impl 1 is running");
        return  departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        System.out.println("Impl 1 is running");
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(int deptId) {
        System.out.println("Impl 1 is running");
        return departmentDao.getById(deptId);
    }

    @Override
    public Department deleteDepartment(int deptId) {
        return null;
    }

    @Override
    public Department updateDeptName(int deptId , String newName) {
        return null;
    }

    @Override
    public Department findByName(String name) {
        return null;
    }
}
