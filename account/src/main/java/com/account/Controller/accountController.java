package com.account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.account.Entity.accountEntity;
import com.account.Service.accountService;

@RestController
@RequestMapping("/account")
public class accountController {
	@Autowired
	accountService service;
	
	@GetMapping("/getDetails/{accNo}")
	public accountEntity getAccDetails(@PathVariable int accNo) {
		return service.getAccDetails(accNo);
		
	}
	
	@PostMapping("/createAccount")
	public boolean createAcc(@RequestBody accountEntity accountEntity) {
		return service.createAcc(accountEntity);
	}
	
	@PutMapping("/addMoney/{accNo}")
	public accountEntity addBalance(@PathVariable int accNo, @RequestParam ("amount") int amount) {
		return service.addBalance(accNo, amount);
		
	}
	
	@PutMapping("/debitMoney/{accNo}")
	public accountEntity withdrawBalance(@PathVariable int accNo, @RequestParam ("amount") int amount) {
		return service.withdrawBalance(accNo, amount);
		
	}
	
	@DeleteMapping("/deleteCust/{id}")
	public boolean deleteCustomer(@PathVariable("id") int id) {
		return service.deleteAccount(id);
	}

}
