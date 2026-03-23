package com.gal.services;

import com.gal.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
}