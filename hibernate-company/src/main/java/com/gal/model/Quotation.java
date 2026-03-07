package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int qid;
	Date qdate;
	Double cost;

	@Override
	public String toString() {
		return "Quotation [qid=" + qid + ", qdate=" + qdate + ", cost=" + cost + "]";
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
