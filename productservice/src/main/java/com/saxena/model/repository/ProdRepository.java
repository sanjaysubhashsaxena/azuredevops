package com.saxena.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.saxena.model.Prod;

@Repository
public interface ProdRepository extends MongoRepository<Prod, Integer> {
	
	Prod findByCustId(String custId);
}
