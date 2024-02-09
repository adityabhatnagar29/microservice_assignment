package com.customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.customer.Entity.customerEntity;
import com.customer.MessageConstants.MessageConstants;
import com.customer.Repository.customerRepository;
import com.customer.Service.customerService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class customerServiceImpl implements customerService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	customerRepository repo;

	@Override
	public List<customerEntity> getAllCustomers() {
		log.info(MessageConstants.GET_ALL_CUSTOMERS);
		return repo.findAll();
	}

	@Override
	public customerEntity getSingleCust(int id) {
		log.info(MessageConstants.GET_SINGLE_CUSTOMER);
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Customer Does not exists"));
	}

	@Override
	public boolean saveCustomer(customerEntity customer) {
		try {
			customer = repo.save(customer);
			log.info(MessageConstants.SAVE_CUSTOMER);
			return true;
		} catch (Exception ex) {
			log.error("Excpetion occured at saveCustomer Method: "+ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		try {
			log.info(MessageConstants.DELETE_CUSTOMER);
			repo.deleteById(id);
			restTemplate.delete("http://localhost:8082/account/deleteCust/"+id);
			return true;
		} catch (Exception ex) {
			log.error("Excpetion occured at deleteCustomer Method: "+ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateCustomer(customerEntity customer) {
		try {
			customer = repo.save(customer);
			log.info(MessageConstants.UPDATE_CUSTOMER);
			return true;
		} catch (Exception ex) {
			log.error("Excpetion occured at updateCustomer Method: "+ex.getMessage());
		}
		return false;
	}

}
