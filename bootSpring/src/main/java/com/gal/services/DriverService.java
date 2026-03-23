package com.gal.services;

import com.gal.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    Driver addDriver(Driver driver);
    List<Driver> getAllDrivers();
}