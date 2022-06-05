package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	InvoiceRepository repository;
	
	@Autowired
	public InvoiceService(InvoiceRepository repository) {
		this.repository = repository;
	}


	public List<Invoice> getAllInvoice() {
		return this.repository.findAll();
	}
	
	public Invoice getByInvoiceNo(String invoice_no) {
		return this.repository.findByInvoiceNo(invoice_no);
	}
	
	public Invoice updateInvoice(String invoice_no) {
		Invoice invoice=this.repository.findByInvoiceNo(invoice_no);
		invoice.setIsActive(false);
		return this.repository.save(invoice);
	}
	
	public Invoice saveInovice(String invoice_no) {
		return this.repository.save(new Invoice(invoice_no, true));
	}
}
