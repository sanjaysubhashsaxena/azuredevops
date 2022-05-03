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

import com.saxena.dto.AllProd;
import com.saxena.model.Prod;
import com.saxena.model.dto.Response;
import com.saxena.service.ProdService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest/api")
@Slf4j
public class ProdController {
	
	@Autowired
	ProdService prodService;

	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/createNewProd")
	public Response createNewProd(@RequestBody Prod request) {
		log.info("createNewProd is called!!");
		if (request == null) {
			return new Response("Prod Object is empty", "S002");
		}
		prodService.createNewProd(request);
		return new Response("Prod record created successfully","C001");
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getAllProd")
	public AllProd getAllProd() {
		log.info("getAllProd is called!!");

		log.debug("1. Debug log");
		log.info("2. info log");
		log.warn("3. Warn log.");
		return prodService.getAllProd();
	}
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/getProd")
	public Prod getProd() {
		log.info("getProd is called!!");
		return prodService.getProd();
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@PutMapping("/updateProd")
	public Response updateProd(@RequestBody Prod request) {
		log.info("updateProd is called!!");
		if (request == null) {
			return new Response("Prod Object is empty", "E001");
		}
		prodService.updateProd(request);
		return new Response("Prod record updated successfully","U001");
	}
	
	/**
	 * 
	 * @param custId
	 * @return
	 */
	@DeleteMapping("/deleteProd/{custId}")
	public Response deleteProd(@RequestParam String custId) {
		prodService.deleteProd(custId);
		return new Response("Prod record deleted successfully","D001");
	}
	
	@GetMapping("/initializeDB")
	public String initializeDB() {
		prodService.initializeDB();
		return "Prod record created successfully";
	}
}
