package com.gal.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private long salary;

    @OneToMany(mappedBy = "driver" , cascade = CascadeType.ALL)
    List<DriverVehicleMapping> driverVehicleMappingList;

    public Driver(){}

    public Driver(String email, String address, String name, long salary, String phone) {
        this.email = email;
        this.address = address;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }
}
