package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "invoice_no")
	private String invoiceNo;
	private Boolean isActive;

	
	public Invoice() {
	}

	public Invoice(String invoiceNo, Boolean isActive) {
		this.invoiceNo = invoiceNo;
		this.isActive = isActive;
	}

	public Invoice(Long id, String invoiceNo, Boolean isActive) {
		this.id = id;
		this.invoiceNo = invoiceNo;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	

	
}
