package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// in DB table must have auto_increment
	// so create your own table
	int itemid;
	String itemtype;
	String itemname;
	@Column(name = "cost", nullable = false)
	double cost;

	public Item(int itmeid, String itemtype, String itemname, double cost) {
		super();
		this.itemid = itmeid;
		this.itemtype = itemtype;
		this.itemname = itemname;
		this.cost = cost;
	}

	public Item() {
		super();
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itmeid) {
		this.itemid = itmeid;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Item [itmeid=" + itemid + ", itemtype=" + itemtype + ", itemname=" + itemname + ", cost=" + cost + "]";
	}

}
