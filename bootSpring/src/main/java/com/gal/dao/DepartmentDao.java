package com.gal.dao;

import com.gal.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface DepartmentDao extends JpaRepository<Department, Integer> {
//
//}

@Repository
public interface DepartmentDao {

    List<Department> findAll();
    Department save(Department department);

    Department getById(int deptId);
}