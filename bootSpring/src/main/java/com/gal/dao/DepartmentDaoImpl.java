package com.gal.dao;

import com.gal.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{
    @Autowired
    private EntityManager entityManager;
    @Transactional
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
