package com.account.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "account")

public class accountEntity {

	@Id
	private Integer accNo;
	private String accType;
	private Integer balance;
	@Transient
	CustomerEntity customer;

}
