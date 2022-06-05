package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	Invoice findByInvoiceNo(String invoice_no);
}
