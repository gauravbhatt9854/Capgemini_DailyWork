package com.gal.controller;
import com.gal.dto.EmployeeVehicleResponseDto;
import com.gal.model.Employee;
import com.gal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/allocate")
        public ResponseEntity<EmployeeVehicleResponseDto> allocateVehicle(@RequestParam("id") Integer id)
        {
            return ResponseEntity.ok(employeeService.allocateVehicle(id));
        }
}