package com.gal.dao;

import com.gal.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver , Integer> {
}
