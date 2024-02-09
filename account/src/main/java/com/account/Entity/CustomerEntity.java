package com.account.Entity;

import lombok.Data;

@Data
public class CustomerEntity {

	private Integer customerId;
	private String name;
	private String address;
	private Integer phoneNumber;
	private char gender;
}
