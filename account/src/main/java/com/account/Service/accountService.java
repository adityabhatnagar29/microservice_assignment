package com.account.Service;

import org.springframework.stereotype.Service;

import com.account.Entity.accountEntity;

@Service
public interface accountService {

	public accountEntity getAccDetails(int accNo);
	public accountEntity addBalance(int accNo, int amount);
	public accountEntity withdrawBalance(int accNo, int amount);
	public boolean createAcc(accountEntity entity);
	public boolean deleteAccount(int accId); 
}
	
