package com.gal.dao;
import com.gal.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDepartmentDao extends JpaRepository<Department, Integer> {

    @Query("select d from Department d where d.name= :name")
    Department findByName(String name);
}
