package com.saxena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saxena.dto.AllCustomer;
import com.saxena.model.Customer;
import com.saxena.model.dto.Response;
import com.saxena.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/api")
@Slf4j
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/createNewCustomer")
	public Response createNewCustomer(@RequestBody Customer request) {
		log.info("createNewCustomer is called!!");
		if (request == null) {
			return new Response("Customer Object is empty", "S002");
		}
		customerService.createNewCustomer(request);
		return new Response("Customer record created successfully","C001");
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getAllCustomer")
	public AllCustomer getAllCustomer() {
		log.info("getAllCustomer is called!!");

		log.debug("1. Debug log");
		log.info("2. info log");
		log.warn("3. Warn log.");
		return customerService.getAllCustomer();
	}
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/getCustomer")
	public Customer getCustomer() {
		log.info("getCustomer is called!!");
		return customerService.getCustomer();
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@PutMapping("/updateCustomer")
	public Response updateCustomer(@RequestBody Customer request) {
		log.info("updateCustomer is called!!");
		if (request == null) {
			return new Response("Customer Object is empty", "E001");
		}
		customerService.updateCustomer(request);
		return new Response("Customer record updated successfully","U001");
	}
	
	/**
	 * 
	 * @param custId
	 * @return
	 */
	@DeleteMapping("/deleteCustomer/{custId}")
	public Response deleteCustomer(@RequestParam String custId) {
		customerService.deleteCustomer(custId);
		return new Response("Customer record deleted successfully","D001");
	}
	
	@GetMapping("/initializeDB")
	public String initializeDB() {
		customerService.initializeDB();
		return "Customer record created successfully";
	}
}
