package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.web.ResourceNotFoundException;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private  CustomerRepository repo;
	public List<Customer> getCustomerList(){
		List<Customer> cust = (List<Customer>) repo.findAll();
		return cust;
	}
	public Customer getOnCustomerById(Long Id) {
		return repo.findById(Id).orElseThrow();
	}
	
	public void save(Customer cust) {
		repo.save(cust);
	}

	

	@Transactional(readOnly = true)
	public Customer addCustomer(Customer customer) {
		repo.save(customer);
		return customer;
	}

	public Customer update(Long id, Customer name) {
		Customer c = repo.findById(id).get();
		c.setId(id);
		c.setName(c.getName());
		return repo.save(c);
	}

	public void delete(Long id) {
		Customer c = repo.findById(id).orElseThrow();
		repo.delete(c);
}
	public List<Customer> getAll(){
		return null;
	}
}
