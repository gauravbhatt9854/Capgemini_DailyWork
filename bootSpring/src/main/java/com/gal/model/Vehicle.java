package com.gal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String number;
    private int seats;
    private int availableSeats;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle" , cascade = CascadeType.ALL)
    List<DriverVehicleMapping> driverVehicleMappingList;

    private Vehicle(){}
    public Vehicle(String name, String number, int seats) {
        this.name = name;
        this.number = number;
        this.seats = seats;
        this.availableSeats = seats;
    }
}
