package com.gal.dao;

import com.gal.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{
    @Autowired
    private EntityManager entityManager;

    public Department save(Department department)
    {
        entityManager.persist(department);
        return department;
    }

    @Override
    public Department getById(int deptId) {
        Query query = entityManager.createQuery("select d from Department d where d.id = :id");
        query.setParameter("id" , deptId);
        Object optionalDepartment = query.getSingleResult();
        if(optionalDepartment.getClass() == Department.class)
        {
            return (Department)optionalDepartment;
        }
        else return null;
    }

    public List<Department> findAll()
    {
        return entityManager.createQuery("select d from  Department d").getResultList();
    }



}
