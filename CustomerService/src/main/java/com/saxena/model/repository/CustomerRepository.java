package com.saxena.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.saxena.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
	
	Customer findByCustId(String custId);
}
