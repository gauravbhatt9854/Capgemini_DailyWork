package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "vendorid")
	int vendorId;

	String name;

	public Vendor(int vendorId, String name) {
		super();
		this.vendorId = vendorId;
		this.name = name;
	}

	public Vendor() {
		super();
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", name=" + name + "]";
	}

}
