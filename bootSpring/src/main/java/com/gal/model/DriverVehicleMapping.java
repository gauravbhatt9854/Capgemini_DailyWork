package com.gal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class DriverVehicleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    private LocalDate localDate;
    private int availableSeats;

    @ManyToMany
    @JoinTable(
            name = "mapping_employee",
            joinColumns = @JoinColumn(name = "mapping_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employeeList;
}