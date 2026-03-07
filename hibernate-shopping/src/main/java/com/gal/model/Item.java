package com.gal.model;

import jakarta.persistence.*;

@Entity
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	long itemid;

	String name;

    @Enumerated(EnumType.STRING)
    Type type;

	Double cost;

    public Item() {}   // REQUIRED by Hibernate

    public Item(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
