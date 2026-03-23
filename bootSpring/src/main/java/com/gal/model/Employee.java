package com.gal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private long salary;

    @JsonIgnore
    @ManyToMany(mappedBy = "employeeList")
    private List<DriverVehicleMapping> driverVehicleMappingList;

    public Employee(){}

    public Employee(String address, String email, String name, long salary, String phone) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }
}