package com.gal.model;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "billno")
    Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Sid" , unique = false)
    Supplier supplier;

    public Supply(Date dateOfSupply, Item item, Long price, Supplier supplier, Long quantiy) {
        this.dateOfSupply = dateOfSupply;
        this.item = item;
        this.price = price;
        this.supplier = supplier;
        this.quantiy = quantiy;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemid" , unique = false)
    Item item;

    @Column(name = "datesupply")
    Date dateOfSupply;

    @Column(name = "Price")
    Long price;

    @Column(name = "qty")
    Long quantiy;
}
