package com.example.demo.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;


@RestController
@RequestMapping("/api")
public class InvoiceController {
	InvoiceService service;
	
	@Autowired
	public InvoiceController(InvoiceService service) {
		this.service = service;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("invoice")
	public List<Invoice> getAllInvoice(){
		return this.service.getAllInvoice();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("invoice/{invoice_no}")
	public Invoice getInvoice(@PathVariable("no")String invoice_no) {
		return this.service.getByInvoiceNo(invoice_no);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("invoice")
	public Invoice updateInvoice(@RequestBody Invoice invoice) {
		return this.service.updateInvoice(invoice.getInvoiceNo());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("generateInvoice")
	public ResponseEntity<Object> generateInvoice() {
		boolean isExists=false;
		HashMap<String, String> hashMap=new HashMap<String, String>();
		String str="";
		while(!isExists) {
			
			str="0097"+generateNumber();
			if(this.service.getByInvoiceNo(str)!=null) {
				isExists=false;
			}else {
				this.service.saveInovice(str);
				isExists=true;
			}
		}
		hashMap.put("invoiceNo", str);
		return new ResponseEntity<Object>(hashMap, HttpStatus.OK);	
	}
	
	
	private int generateNumber() {
		int count=0;
		Set<Integer> uniques = new HashSet<>(15000);
	    Random random = new Random();
	    for (int i = 0; i < 10000;) {
	        int number = random.nextInt(Integer.MAX_VALUE);
	        if (uniques.add(number)) {
	        	count=number;
	            i++;
	        }
	    }
	    return count;
	}
}
