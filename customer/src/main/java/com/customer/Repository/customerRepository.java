package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.customerEntity;

public interface customerRepository extends JpaRepository<customerEntity, Integer>{

}
