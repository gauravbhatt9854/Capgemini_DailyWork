package com.gal.services;

import com.gal.dao.DriverDao;
import com.gal.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverDao driverDao;

    @Override
    public Driver addDriver(Driver driver) {
        return driverDao.save(driver);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDao.findAll();
    }
}