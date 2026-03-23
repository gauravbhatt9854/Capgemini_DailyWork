package com.gal.services;

import com.gal.dao.VehicleDao;
import com.gal.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }
}
