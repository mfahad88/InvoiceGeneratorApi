package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Invoice {

	private Long id;
	
	private String invoice_no;
	
	private Timestamp created_date;
	
	private Timestamp updated_date;
	
	private Boolean isActive;

	
	public Invoice() {
	}

	public Invoice(String invoice_no, Boolean isActive) {
		this.invoice_no = invoice_no;
		this.isActive = isActive;
	}

	public Invoice(String invoice_no, Timestamp updated_date, Boolean isActive) {
		this.invoice_no = invoice_no;
		this.updated_date = updated_date;
		this.isActive = isActive;
	}

	public Invoice(Long id, String invoice_no, Timestamp created_date, Timestamp updated_date, Boolean isActive) {
		this.id = id;
		this.invoice_no = invoice_no;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}

	public Timestamp getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Timestamp updated_date) {
		this.updated_date = updated_date;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
