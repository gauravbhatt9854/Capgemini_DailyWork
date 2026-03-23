package com.gal.services;

import com.gal.dto.EmployeeVehicleResponseDto;
import com.gal.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();

    EmployeeVehicleResponseDto allocateVehicle(int id);
}