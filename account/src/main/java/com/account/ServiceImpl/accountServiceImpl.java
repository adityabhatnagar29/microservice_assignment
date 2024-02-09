package com.account.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.account.Entity.CustomerEntity;
import com.account.Entity.accountEntity;
import com.account.MessageConstant.MessageConstants;
import com.account.Repository.accountRepository;
import com.account.Service.accountService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class accountServiceImpl implements accountService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	accountRepository repository;

	@Override
	public accountEntity getAccDetails(int accNo) {

		log.info(MessageConstants.GET_ACCOUNT_DETAILS);
		accountEntity account = repository.findById(accNo)
				.orElseThrow(() -> new RuntimeException("account with given id does not exists!!"));

		log.info(MessageConstants.GET_CUSTOMER_DETAILS);
		CustomerEntity customer = restTemplate
				.getForObject("http://localhost:8081/customer/getCustomer/" + account.getAccNo(), CustomerEntity.class);
		account.setCustomer(customer);
		return account;
	}

	@Override
	public accountEntity addBalance(int accNo, int amount) {
		log.info(MessageConstants.ADD_BALANCE);
		accountEntity account = repository.findById(accNo)
				.orElseThrow(() -> new RuntimeException("account with given id does not exists!!"));
		try {
			CustomerEntity customer = restTemplate.getForObject(
					"http://localhost:8081/customer/getCustomer/" + account.getAccNo(), CustomerEntity.class);

			if (!ObjectUtils.isEmpty(customer) && amount >= 0) {
				int newBalance = account.getBalance() + amount;
				account.setBalance(newBalance);
				account.setCustomer(customer);
				repository.save(account);
			}
		} catch (Exception ex) {
			log.error("Exception occured at addBalance: " + ex.getMessage());
		}

		return account;
	}

	@Override
	public accountEntity withdrawBalance(int accNo, int amount) {
		log.info(MessageConstants.WITHDRAW_BALANCE);
		accountEntity account = repository.findById(accNo)
				.orElseThrow(() -> new RuntimeException("account with given id does not exists!!"));
		try {

			CustomerEntity customer = restTemplate.getForObject(
					"http://localhost:8081/customer/getCustomer/" + account.getAccNo(), CustomerEntity.class);

			if (!ObjectUtils.isEmpty(customer) && amount >= 0 &&amount<account.getBalance()) {
				int newBalance = account.getBalance() - amount;
					account.setCustomer(customer);
					account.setBalance(newBalance);
					repository.save(account);
			}else {
				account.setBalance(account.getBalance());
				account.setCustomer(customer);
			}
		} catch (Exception ex) {
			log.error("Exception occured at withdrawBalance: " + ex.getMessage());
		}
		return account;

	}

	@Override
	public boolean deleteAccount(int accNo) {
		try {
			log.info(MessageConstants.DELETE_ACCOUNT_DETAILS);
			repository.deleteById(accNo);
			return true;
			
		} catch (Exception ex) {
			log.error("Exception in deleting Account: " +ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean createAcc(accountEntity entity) {
		log.info(MessageConstants.SAVING_ACCOUNT_DETAILS);
		repository.save(entity);
		return true;
	}

}
