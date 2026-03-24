package com.gal.service;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public Department getDeptById(long id) {
        return departmentDao.getDeptById(id);
    }

    public Department addDepartment(Department department) {
        return null;
    }
}
