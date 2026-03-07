package com.gal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Parking {

	// custom managment of sequence
	@SequenceGenerator(name = "parkingSequence", initialValue = 201, allocationSize = 1, sequenceName = "parkingSeq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkingSequence")
	// hibenate will create a new sequence (mysql:table) hibernate_sequence
	int parkingid;

	int floorno;
	String slotnumber;
	// always have default constructor else HIBERNATE will NOT WORK
	// mapping of one entity to another
	@OneToOne
	@JoinColumn(name = "empid")
	private Employee employee; // is not one column : hibernate will add new column in parking table
	// employee_employee_id , foreign key references Employee(employee_id)

	public Parking(int parkingid, int floorno, String slotnumber) {
		super();
		this.parkingid = parkingid;
		this.floorno = floorno;
		this.slotnumber = slotnumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Parking() {
		super();
	}

	public int getParkingid() {
		return parkingid;
	}

	public void setParkingid(int parkingid) {
		this.parkingid = parkingid;
	}

	public int getFloorno() {
		return floorno;
	}

	public void setFloorno(int floorno) {
		this.floorno = floorno;
	}

	public String getSlotnumber() {
		return slotnumber;
	}

	public void setSlotnumber(String slotnumber) {
		this.slotnumber = slotnumber;
	}

	@Override
	public String toString() {
		return "Parking [parkingid=" + parkingid + ", floorno=" + floorno + ", slotnumber=" + slotnumber + "]";
	}

}
