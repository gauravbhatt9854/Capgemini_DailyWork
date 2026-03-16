package com.gal.services;

import com.gal.dao.JpaDepartmentDao;
import com.gal.model.Department;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DepartmentServiceImpl2 implements DepartmentService {

    @Autowired
    private JpaDepartmentDao departmentDao;

    @Override
    public Department saveDepartment(Department department) {
        System.out.println("Impl 2 is running");
        return departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        System.out.println("Impl 2 is running");
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(int deptId) {
        System.out.println("Impl 2 is running");
        Optional<Department> optionalDepartment = departmentDao.findById(deptId);
        return optionalDepartment.get();
    }

    @Override
    public Department deleteDepartment(int deptId) {
        Optional<Department> optionalDepartment = departmentDao.findById(deptId);
        departmentDao.deleteById(deptId);
        return optionalDepartment.get();
    }

    @Override
    public Department updateDeptName(int deptId , String newName) {
        Optional<Department> optionalDepartment = departmentDao.findById(deptId);
        optionalDepartment.get().setName(newName);
        departmentDao.save(optionalDepartment.get());
        return  optionalDepartment.get();
    }

    @Override
    public Department findByName(String name) {
        return departmentDao.findByName(name);
    }
}
