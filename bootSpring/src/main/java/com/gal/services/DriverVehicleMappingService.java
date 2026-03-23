package com.gal.services;

import com.gal.dao.DriverVehicleMappingDao;
import com.gal.model.DriverVehicleMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverVehicleMappingService {

    private final DriverVehicleMappingDao repo;

    public DriverVehicleMappingService(DriverVehicleMappingDao repo) {
        this.repo = repo;
    }

    public DriverVehicleMapping save(DriverVehicleMapping mapping) {
        return repo.save(mapping);
    }

    public List<DriverVehicleMapping> getAll() {
        return repo.findAll();
    }

    public DriverVehicleMapping getById(long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public DriverVehicleMapping update(int id, DriverVehicleMapping newMapping) {
        DriverVehicleMapping old = getById(id);

        old.setDriver(newMapping.getDriver());
        old.setVehicle(newMapping.getVehicle());
        old.setLocalDate(newMapping.getLocalDate());
        old.setAvailableSeats(newMapping.getAvailableSeats());
        old.setEmployeeList(newMapping.getEmployeeList());

        return repo.save(old);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}