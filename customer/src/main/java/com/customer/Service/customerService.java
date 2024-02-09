package com.customer.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.Entity.customerEntity;

@Service
public interface customerService {
	
	public List<customerEntity> getAllCustomers();

	public customerEntity getSingleCust(int id);

	public boolean saveCustomer(customerEntity customer);

	public boolean deleteCustomer(int id);

	public boolean updateCustomer(customerEntity customer);

}
