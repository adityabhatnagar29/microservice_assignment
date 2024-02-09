package com.customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.customerEntity;
import com.customer.Service.customerService;

@RestController
@RequestMapping("/customer")
public class customerController {

	@Autowired
	private customerService service;
	
	@GetMapping("/getCustomers")
	public List<customerEntity> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@GetMapping("/getCustomer/{id}")
	public customerEntity getCustomer(@PathVariable("id") int id) {
		return service.getSingleCust(id);
	}

	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody customerEntity customer) {
		return service.saveCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public boolean updateCustomer(@RequestBody customerEntity customer) {
		return service.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteCust/{id}")
	public boolean deleteCustomer(@PathVariable("id") int id) {
		return service.deleteCustomer(id);
	}
}
