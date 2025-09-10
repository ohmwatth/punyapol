package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerReq;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class RestCustomerController {
	@Autowired
	private CustomerService custService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getCustomer(){
		List<Customer> customers = custService.getAll();
		return new ResponseEntity<>(customers, HttpStatus.OK);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		Customer customer = custService.getOnCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json",produces="application/json")
	public ResponseEntity<Customer> createCustomer(@org.springframework.web.bind.annotation.RequestBody Customer cust){
		System.out.println("NEW CUSTOMER:" + cust);
		Customer custnew = custService.addCustomer(cust);
		return new ResponseEntity<>(custnew, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer cust){
		Customer updatecust = custService.update(id, cust);
		return new ResponseEntity<>(updatecust, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		custService.delete(id);
	}
	}
