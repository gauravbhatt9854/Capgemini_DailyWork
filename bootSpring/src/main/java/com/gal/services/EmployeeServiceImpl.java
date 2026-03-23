package com.gal.services;

import com.gal.dao.DriverDao;
import com.gal.dao.EmployeeDao;
import com.gal.dao.DriverVehicleMappingDao;
import com.gal.dao.VehicleDao;
import com.gal.dto.EmployeeVehicleResponseDto;
import com.gal.model.Employee;
import com.gal.model.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private DriverVehicleMappingDao employeeVehicleDao;


    @Autowired
    private DriverDao driverDao;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public EmployeeVehicleResponseDto allocateVehicle(int id) {
    // check existing allocation
        Optional<Employee> employee = employeeDao.findById(id);
        if(employee.isEmpty()) throw new RuntimeException("employee not exist");

        EmployeeVehicle employeeVehicle = employee.get()
                .getEmployeeVehiclesList()
                .stream()
                .filter(x-> x.getAssignedAt().equals(LocalDate.now())).findFirst().orElse(null);

        if(employeeVehicle!=null) return new EmployeeVehicleResponseDto(employeeVehicle);

        Vehicle available = vehicleDao.findAll()
                .stream()
                .filter(x-> x.getAvailableSeats() >= 1)
                .sorted(Comparator.comparing(Vehicle::getId))
                .findFirst().orElse(null);


        if(available==null) throw new RuntimeException("no available cars");

        EmployeeVehicle employeeVehicle1 = new EmployeeVehicle();
        employeeVehicle1.setEmployee(employee.get());
        employeeVehicle1.setVehicle(available);
        employeeVehicle1.setAssignedAt(LocalDate.now());
        employeeVehicle1.setDriver(driver);
        available.setAvailableSeats(available.getAvailableSeats()-1);
        vehicleDao.save(available);
        employeeVehicleDao.save(employeeVehicle1);

        return new EmployeeVehicleResponseDto(employeeVehicle1);
    }
}