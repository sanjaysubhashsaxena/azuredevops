package com.saxena.dto;

import java.util.List;

import com.saxena.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AllCustomer {
	private List<Customer> customers;
}
