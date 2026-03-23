package com.gal.controller;

import com.gal.model.Driver;
import com.gal.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }
}