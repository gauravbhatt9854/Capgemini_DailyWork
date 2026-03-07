package com.gal.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JoinColumn(name = "Sid")
    Long id;

    @Column(name = "Sname")
    String name;

    @Column(name = "Srank")
    Double rank;
    String city;

    public Supplier(String city, String name, Double rank) {
        this.city = city;
        this.name = name;
        this.rank = rank;
    }

    @OneToMany(mappedBy = "supplier")
    List<Supply> listOfSupply = new ArrayList<>();
}
