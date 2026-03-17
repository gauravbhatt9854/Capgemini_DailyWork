package com.gal.services;

import com.gal.dao.JpaDepartmentDao;
import com.gal.model.Department;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DepartmentServiceImpl2 implements DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl2.class);

    @Autowired
    private JpaDepartmentDao departmentDao;

    @Override
    public Department saveDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Department getDepartmentById(int deptId) {
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

    @Override
    public Department putDepartment(Department department) {
        Optional<Department> existing = departmentDao.findById(department.getId());
        if(existing.isEmpty())
        {
            log.error("trying to update an department that doesn't even exist");
            throw new RuntimeException("item not exist but still trying put operation");
        }
        departmentDao.save(department);
        return department;
    }
}
