package com.customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class customerEntity {

	@Id
	private Integer customerId;
	private String name;
	private String address;
	private Integer phoneNumber;
	private char gender;
}
