package com.gal.dao;

import com.gal.model.DriverVehicleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.gal.model.Driver;

import java.util.List;

public interface DriverVehicleMappingDao extends JpaRepository<DriverVehicleMapping, Long> {

}